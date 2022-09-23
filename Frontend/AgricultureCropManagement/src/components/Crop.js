import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CropList from "./CropList";
import "bootstrap/dist/css/bootstrap.min.css";
import AddCrop from "./AddCrop";
import NotFound from "./NotFound";

function Crop() {
  return (
    <BrowserRouter>
      <div>
        <div>
          <Routes>
            <Route exact path="/croplist" element={<CropList />} />
            <Route path="/addcrop" element={<AddCrop />} />
            <Route path="/addcrop/:id" element={<AddCrop />} />
            <Route path="/*" element={<NotFound />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default Crop;
