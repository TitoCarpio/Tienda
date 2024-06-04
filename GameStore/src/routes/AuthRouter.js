import React from "react";
import { Route, Routes, Navigate } from "react-router-dom";
import LoginScreen from "../screens/LoginScreen";
import RegisterScreen from "../screens/RegisterScreen";

const AuthRouter = ({ setUsuario }) => {
  return (
    <Routes>
      <Route path="/auth/login" element={<LoginScreen setUsuario={setUsuario} />} />
      <Route path="/auth/register" element={<RegisterScreen setUsuario={setUsuario} />} />
      <Route path="*" element={<Navigate to="/auth/login" />} />
    </Routes>
  );
};

export default AuthRouter;