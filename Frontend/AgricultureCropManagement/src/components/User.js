import React from "react";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import CropService from "../services/CropService";
import "./style.css";

const User = () => {
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

  const handleDelete = (id) => {
    console.log("Printing id", id);
    CropService
      .remove(id)
      .then((response) => {
        console.log("Crop Details deleted successfully", response.data);
        init();
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  return (
    <div className="container">
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <h3>List of Crop Details</h3>
      <hr />
      <div>
        <Link to="/addcrop" className="btn  mb-2" id="aprod">
          Add Crop Details
        </Link>
        <table className="table table-bordered table-striped">
          <thead className="thead-dark">
            <tr>
            <th> Crop Id</th>
              <th> Crop Name</th>
              <th> Quantity(in Katha)</th>
              <th> Price</th>
              <th> Farmer Phone_no</th>
              <th> Actions</th>
            </tr>
          </thead>
          <tbody>
            {crops.map((crops) => (
              <tr key={crops.id}>
                <td>{crops.id}</td>
                <td>{crops.cropName}</td>
                <td>{crops.quantity}</td>
                <td>{crops.price}</td>
                <td>{crops.ph_no}</td>
                <td>
                  <Link
                    className="btn "
                    id="uprod"
                    to={`/crops/edit/${crops.id}`}
                  >
                    Edit Crop Details
                  </Link>

                  <button
                    id="dprod"
                    onClick={() => {
                      handleDelete(crops.id);
                    }}
                  >
                    Delete Crop
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default User;
