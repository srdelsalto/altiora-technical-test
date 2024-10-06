import React, { useState, useEffect } from "react";

const ClienteForm = ({ clienteActual, onGuardar }) => {
    const [nombre, setNombre] = useState("");
    const [apellido, setApellido] = useState("");

    // Si estamos editando un cliente, llenar los campos con los datos actuales
    useEffect(() => {
        if (clienteActual) {
            console.log(clienteActual);
            setNombre(clienteActual.firstName);
            setApellido(clienteActual.lastName);
        } else {
            setNombre("");
            setApellido("");
        }
    }, [clienteActual]);

    const manejarSubmit = (e) => {
        e.preventDefault();
        const cliente = {
            id: clienteActual?.id,
            firstName: nombre,
            lastName: apellido
        }
        onGuardar(cliente);
        setNombre("");
        setApellido("");
    };

    return (
        <form onSubmit={manejarSubmit} className="mt-2 mb-2 container">
            <h3>{clienteActual ? "Editar Cliente" : "Agregar Cliente"}</h3>
            <div className="form-group mx-2">
                <label>Nombre</label>
                <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese el nombre"
                    value={nombre}
                    onChange={(e) => setNombre(e.target.value)}
                    required
                />
            </div>
            <div className="form-group mx-2">
                <label>Apellido</label>
                <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese el apellido"
                    value={apellido}
                    onChange={(e) => setApellido(e.target.value)}
                    required
                />
            </div>
            <button type="submit" className="btn btn-primary mt-3 mx-2">
                {clienteActual ? "Actualizar" : "Crear"}
            </button>
        </form>
    );
};

export default ClienteForm;
