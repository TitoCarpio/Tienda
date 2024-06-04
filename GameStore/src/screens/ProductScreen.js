import React, { useState, useEffect } from "react";
import PrimaryButton from "../components/Buttons/PrimaryButton";
import toast, { Toaster } from "react-hot-toast";
import { IoArrowBack } from "react-icons/io5";
import { MdOutlinePayments } from "react-icons/md";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { API_URL } from "../utils/constants";

const ProductScreen = () => {
  const { idProduct } = useParams();
  const navigate = useNavigate();

  const [producto, setProducto] = useState(null);
  const [error, setError] = useState(false);

  useEffect(() => {
    axios
      .get(`${API_URL}/articulo/${idProduct}`)
      .then((res) => {
        const { data } = res;
        setProducto(data);
      })
      .catch((err) => console.log(err));
  }, []);

  // const onShow = () => setShow(true);
  const onBack = () => navigate("/home");

  //funcion que se encarga de realizar la peticion a la api para pagar
  const onPay = () => {
    axios
      .post(`${API_URL}/compra`, {
        articulo: idProduct,
        cantidad: document.getElementById("cantidad").value,
        usuario: localStorage.getItem("usuario"),
      })
      .then((res) => {
        const { data } = res;
        console.log(data);
        toast.success(data);
      })
      .catch(() => {
        setError(true);
        toast.error("No se pudo realizar la compra, saldo insuficiente");
      });
  };


  if (!producto) return null;

  const { nombre, descripcion, imagen } = producto;

  return (
    <section className="text-gray-700 body-font overflow-visible bg-white h-screen">
      {/* <RatingModal show={show} onRating={onRating} setShow={setShow} /> */}
      <div className="container px-5 py-24 mx-auto">
        <div className="lg:w-4/5 mx-auto flex flex-wrap ">
          <img
            alt="ecommerce"
            className="lg:w-1/2 w-full object-contain object-center  border border-gray-200 rounded-3xl shadow-lg h-auto"
            src={imagen}
            style={{ height: "700px" }}
          />
          <div className="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0 justify-items-center flex flex-col">
            <h1 className="text-gray-900 text-3xl title-font font-medium mb-1">
              {nombre}
            </h1>

            <p className="leading-relaxed">{descripcion}</p>

            <div className="flex flex-col sm:flex-row items-center mt-6 pb-5 border-b-2 border-gray-200 mb-5 space-y-4 sm:space-y-0 sm:space-x-4">
              <label htmlFor="cantidad" className="font-semibold text-lg">
                Cantidad:
              </label>
              <input
                type="number"
                id="cantidad"
                name="cantidad"
                min="1"
                max="10"
                step="1"
                defaultValue={1}
                className="w-20 text-center border border-gray-300 rounded-md py-2 px-3 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
              />
            </div>

            <div className="flex justify-between">
              <PrimaryButton onClick={onBack}>
                <IoArrowBack size={20} className="mr-2" />
                Regresar
              </PrimaryButton>
              <PrimaryButton onClick={onPay} color="bg-green-600">
                <MdOutlinePayments size={20} className="mr-2" />
                Comprar
              </PrimaryButton>
              {error && <Toaster position="top-center" reverseOrder={false} />}
              {!error && <Toaster position="top-right" reverseOrder={false} />}
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default ProductScreen;
