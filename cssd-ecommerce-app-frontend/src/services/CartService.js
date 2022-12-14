import axios from "axios";
const USER_URL = "http://localhost:8080/api/v1";

const getToken = () => {
    return localStorage.getItem("USER_KEY");
};

export const getCart= (id) => {
    return axios({
        method: "GET",
        url: `${USER_URL}/getCart/${id}`,
        headers: {
            Authorization: "Bearer " + getToken(),
        },
    });
};

export const addToCart= (id,customer) => {
    return axios({
        method: "POST",
        url: `${USER_URL}/addCart/${id}/${customer}`,
        headers: {
            Authorization: "Bearer " + getToken(),
        },
    });
};

export const deleteFromCart= (id,customer) => {
    return axios({
        method: "DELETE",
        url: `${USER_URL}/deleteCart/${id}/${customer}`,
        headers: {
            Authorization: "Bearer " + getToken(),
        },
    });
};