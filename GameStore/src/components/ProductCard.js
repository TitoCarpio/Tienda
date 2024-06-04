import React from "react";
import { Link } from "react-router-dom";

const ProductCard = ({ articulo }) => {
  const {
    id,
    nombre,
    descripcion,
    precio,
    imagen,
  } = articulo;

  return (
    <div className=" py-6 flex flex-col justify-center sm:py-12 mb-8">
      <div className="py-3 sm:max-w-xl sm:mx-auto">
        <div className="bg-yellow-50 shadow-lg border-gray-100 max-h-80	 border sm:rounded-3xl p-8 flex space-x-8">
          <div className="h-auto overflow-visible w-1/2">
            <img className="rounded-3xl shadow-lg" src={imagen} alt="" />
          </div>
          <div className="flex flex-col w-1/2 space-y-4">
            <Link
              to={`/product/${id}`}
              className="flex justify-between items-start"
            >
              <h2 className="text-3xl font-bold mr-4 hover:underline">{nombre}</h2>
              
            </Link>
            <div className="justify-items-center flex ">
              <div className="bg-yellow-400 font-bold rounded-xl p-1 w-12 flex-col justify-center">${precio}</div>
              {/* <div className="text-lg text-gray-800">{fechaLanzamiento}</div> */}
            </div>
            <p className=" text-gray-400 max-h-40 overflow-y-hidden line-clamp">
              {descripcion}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;