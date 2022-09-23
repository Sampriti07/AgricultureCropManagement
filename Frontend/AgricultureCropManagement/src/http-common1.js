import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8000/crop",
  headers: {
    "Content-Type": "application/json",
  },
});
