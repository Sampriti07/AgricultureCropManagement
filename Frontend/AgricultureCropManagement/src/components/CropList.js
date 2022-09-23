import React from "react";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import CropService from "../services/CropService";

const CropList = () => {
  const [crops, setCrops] = useState([]);

  const init = () => {
    CropService
      .getAll()
      .then((response) => {
        console.log("Printing Crop Details", response.data);
        setCrops(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  useEffect(() => {
    init();
  }, []);


  return (
    <div className="container">
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <h3>List of Crop Details</h3>
      <hr />
      <div>
        <table className="table table-bordered table-striped">
          <thead className="thead-dark">
            <tr>
              <th> Crop Name</th>
              <th> Quantity(in Katha)</th>
              <th> Price</th>
              <th> Farmer Phone No. </th>
              <th> Action </th>
            </tr>
          </thead>
          <tbody>
            {crops.map((crops) => (
              <tr key={crops.id}>
                <td>{crops.cropName}</td>
                <td>{crops.quantity}</td>
                <td>{crops.price}</td>
                <td>{crops.ph_no}</td>
                <td>
                  <a href={`http://localhost:8001/`} className="btn btn-outline-primary">
                  
                    Book Now</a>
                  
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default CropList;
