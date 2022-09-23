import httpClient from "../http-common1";

const getAll = () => {
  return httpClient.get("/getall");
};

const get = (id) => {
  return httpClient.get(`/get/${id}`);
};

const create = (data) => {
  return httpClient.post("/save", data);
};

const update = (data,id) => {
  return httpClient.put(`/update/${id}`,data);
};

const remove = (id) => {
  return httpClient.delete(`/delete/${id}`);
};

export default { getAll, get, create, update, remove };
