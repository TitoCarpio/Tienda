import React from 'react'
import { Route, Routes, Navigate } from "react-router-dom";
import HomeScreen from '../screens/HomeScreen';
import ProductScreen from '../screens/ProductScreen';

const UserRouter = ({ setUsuario}) => {
    return (
        <Routes>
            <Route path="/home" element={<HomeScreen setUsuario={setUsuario}  />} />
            <Route path="/product/:idProduct" element={<ProductScreen />} />
            <Route path="*" element={<Navigate to="/home" />} />
        </Routes>
    )
}

export default UserRouter