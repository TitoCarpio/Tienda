import axios from "axios";
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import PrimaryButton from "../components/Buttons/PrimaryButton";
import ProductList from "../components/ProductList";
import { API_URL } from "../utils/constants";

const HomeScreen = ({ setUsuario }) => {
  const [articulos, setArticulos] = useState([]);

  

  useEffect(() => {
    axios
      .get(`${API_URL}/articulos`)
      .then((response) => {
        console.log(response);
        const { data } = response;
        console.log(data);
        setArticulos(data);
        // setOldMovies(peliculas);
      })
      .catch((error) => console.log(error));
  }, []);

  //funcion para cerrar sesion
  const onLogout = () => {
    setUsuario(null);
    localStorage.removeItem("usuario");
  }

  
  // const onAddMovie = () => navigate('/movie/new');

  return (
    <div>
      <div className="flex justify-end items-center bg-blue-300">
        <div className= "flex items-center justify-center bg-green-700 font-semibold text-white p-2 w-32 rounded-full   shadow-lg  ">saldo</div>
        <div className="">
          <PrimaryButton onClick={onLogout}>Logout</PrimaryButton>
        </div>
      </div>

      <ProductList articulos={articulos} />
    </div>
  );
};

export default HomeScreen;