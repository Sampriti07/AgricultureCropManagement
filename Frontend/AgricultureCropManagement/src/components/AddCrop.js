import React from "react";
import { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import CropService from "../services/CropService";

const AddCrop = () => {
  //const [id, setId] = useState("");
  const [cropName, setCropName] = useState("");
  const [quantity, setQuantity] = useState("");
  const [price, setPrice] = useState("");
  const [ph_no, setPh_no] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const saveCrop = (e) => {
    e.preventDefault();

    const crops = { cropName, quantity, price, ph_no, id };

    if (id) {
      //update
      CropService
        .update(crops,id)
        .then((response) => {
          alert("Details updated Successfully");
          console.log("Crop Details updated successfully", response.data);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    } else {
      // create
      CropService
        .create(crops)
        .then((response) => {
          alert("Details Saved");
          console.log("Crop details added successfully", response.data);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  };

  useEffect(() => {
    if (id) {
      CropService.get(id)
        .then((crops) => {
          //setId(crop.data.id);
          setCropName(crops.data.cropName);
          setQuantity(crops.data.quantity);
          setPrice(crops.data.price);
          setPh_no(crops.data.ph_no);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  }, []);

  return (
    <div className="container">
      <br></br>
      <br></br>
      <h3 className="ab">
        <b>
          <u>Add/Update Crop Details</u>
        </b>
      </h3>
      <form className="form1">
        <br></br>
        <br></br>
        <div className="form-group">
          {/* <p className="prsub">Customer Name:</p> */}
          <input
            type="text"
            className="form-control col-4"
            id="cropName"
            value={cropName}
            onChange={(e) => setCropName(e.target.value)}
            placeholder="Enter your crop name"
          />
        </div>
        <br></br>
        <div className="form-group">
          {/* <p className="prsub">Customer Address:</p> */}
          <input
            type="text"
            className="form-control col-4"
            id="quantity"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            placeholder="Enter your crop quantity in Katha"
          />
        </div>
        <br></br>
        <div className="form-group1">
          {/* <p className="prsub">Customer Address:</p> */}
          <input
            type="text"
            className="form-control col-4"
            id="price"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            placeholder="Enter your crop price"
          />
        </div>
        <br></br>
        <div className="form-group">
          {/* <p className="prsub">Customer Address:</p> */}
          <input
            type="text"
            className="form-control col-4"
            id="ph_no"
            value={ph_no}
            onChange={(e) => setPh_no(e.target.value)}
            placeholder="Enter your Phone number"
          />
        </div>
        <br></br>
        <br></br>
        <br></br>
        
      </form>
      <div className="Buttons">
          <button onClick={(e) => saveCrop(e)} id="svep">
            Save
          </button>
          <Link to="/user">
            <button className="bckc">Back To list</button>
          </Link>
        </div>

    </div>
  );
};

export default AddCrop;
