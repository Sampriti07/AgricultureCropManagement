import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import "./components/style.css";
import { BrowserRouter as Router } from "react-router-dom";
import AuthService from "./components/Login/services/auth.service";

import Login from "./components/Login/Lcompo/login.component";
import Register from "./components/Login/Lcompo/register.component";
import Home from "./components/Login/Lcompo/home.component";
import Profile from "./components/Login/Lcompo/profile.component";
import BoardDealer from "./components/Login/Lcompo/board-dealer.component";
import BoardFarmer from "./components/Login/Lcompo/board-farmer.component";
import BoardAdmin from "./components/Login/Lcompo/board-admin.component";
//import AuthVerify from "./components/Login/common/auth-verify";
import EventBus from "./components/Login/common/EventBus";


import "./index.css";
import AddCrop from "./components/AddCrop";
import Crop from "./components/Crop";
import CropList from "./components/CropList";
import NotFound from "./components/NotFound";
import User from "./components/User";
import {Footer,About,Contact} from "./components";

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showModeratorBoard: user.roles.includes("ROLE_FARMER"),
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
    
    EventBus.on("logout", () => {
      this.logOut();
    });
  }

  componentWillUnmount() {
    EventBus.remove("logout");
  }

  logOut() {
    AuthService.logout();
    this.setState({
      showModeratorBoard: false,
      showAdminBoard: false,
      currentUser: undefined,
    });
  }

  render() {
    const { currentUser, showModeratorBoard, showAdminBoard } = this.state;

    return (
      <div>
        <nav className="navbar navbar-expand navbar-light bg-light">
            <b><i>Tienda</i></b>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/"} className="nav-link">
                Home
              </Link>
            </li>

          
            <li className="nav-item">
              <Link to={"/about"} className="nav-link">
                About Us
              </Link>
            </li>

           
            <li className="nav-item">
              <Link to={"/contact"} className="nav-link">
                Contact Us
              </Link>
            </li>

            {showModeratorBoard && (
              <li className="nav-item">
                <Link to={"/user"} className="nav-link">
                  Crop_Seller
                </Link>
              </li>
            )}

            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link">
                  Admin Board 
                </Link>
              </li>
            )}

            {currentUser && (
              <li className="nav-item">
                <Link to={"/croplist"} className="nav-link">
                  Crop_Booking
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  LogOut
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
        </nav>

        <div className="container mt-3">
        <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/register" element={<Register />} />
      <Route exact path="/croplist" element={<CropList />} /> 
      <Route path="/addcrop" element={<AddCrop />} />
      
      <Route path="/*" element={<NotFound />} />
      <Route path="/user" element={<User />} />
      

             
            
            
            <Route exact path="/profile" element={<Profile/>} />
            <Route path="/croplist" element={<BoardDealer/>} />
            <Route path="/user" element={<BoardFarmer/>} />
            
            <Route exact path="/crops/edit/:id" element={<AddCrop />} />
            <Route path="/admin" element={<BoardAdmin/>} />

       
      
          </Routes>
          <Footer />
        </div>

        { /*<AuthVerify logOut={this.logOut}/> */ }
      </div>
    );
  }
}

export default App;