import React, { useState, useEffect } from "react";
import AuthRouter from "./routes/AuthRouter";
import UserRouter from "./routes/UserRouter";
import { HashRouter } from "react-router-dom";

function Tienda() {
  const [usuario, setUsuario] = useState(
    localStorage.getItem("usuario") || null
  );

  // Guardo el id del usuario en el localStorage
  useEffect(() => {
    if (usuario) localStorage.setItem("usuario", usuario);
  }, [usuario]);

  return (
    // HashRouter es un componente que envuelve toda la aplicación
    <HashRouter>
      {usuario && <UserRouter setUsuario = {setUsuario}/>}
      {!usuario && <AuthRouter setUsuario={setUsuario} />}
    </HashRouter>
  );
}

export default Tienda;
