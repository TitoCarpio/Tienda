import React, { useState } from "react";
import AuthButton from "../components/Buttons/AuthButton";
import AuthInput from "../components/Inputs/AuthInput";
import FooterLink from "../components/FooterLink";
import logo from "../images/bg-loging.jpg"
import axios from "axios";
import { API_URL } from "../utils/constants";

const LoginScreen = ({ setUsuario }) => {

  const [formValues, setFormValues] = useState({
    email: "",
    contrasena: "",
  });

  const [loading, setLoading] = useState(false);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
    console.log(formValues);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    setLoading(true);
    axios.post(`${API_URL}/login`, formValues)
    .then((response) => {
      const { data } = response;
      const { id } = data;
      console.log(id);
      setLoading(false);
      setUsuario(id);
    })
    .catch((error) => {
      console.log(error);
      setLoading(false);
    });
  }

  return (
    <div className="w-full h-screen flex justify-center items-center bg-blue-300">
      
      <form
        className="bg-slate-300 w-96 h-5/6 rounded-lg pt-8 pb-8 px-8 flex flex-col items-center justify-center"
        onSubmit={handleSubmit}
      >
        <label className="font-light text-4xl mb-4">
          Game <span className="font-bold">STORE</span>
        </label>
        <AuthInput
          type="email"
          name="email"
          placeholder="Email"
          onChange={handleChange}
        />
        <AuthInput
          type="password"
          name="contrasena"
          placeholder="Password"
          onChange={handleChange}
        />
        <AuthButton loading={loading}>Login</AuthButton>
        <FooterLink
          label="Need an account?"
          path="/auth/register"
          link="Create an account"
        />
      </form>
      <div className="w-1/2 h-5/6 bg-green-300">
        <img
          src={logo}
          alt="login"
          className="w-full h-full object-cover rounded-lg"
        />
      </div>
    </div>
  );
};

export default LoginScreen;