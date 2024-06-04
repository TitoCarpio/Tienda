import React from "react";
import ProductCard from "./ProductCard";

const ProductList = ({ articulos }) => {
  return (
    <div className="flex justify-evenly flex-wrap">
      {articulos.map((articulo) => (
        <ProductCard key={articulo.id} articulo={articulo} />
      ))}
    </div>
  );
};

export default ProductList;