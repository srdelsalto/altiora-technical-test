import React, { useState, useEffect } from "react";

const ArticuloForm = ({ articuloActual, onGuardar }) => {
    const [nombre, setNombre] = useState("");
    const [precioUnitario, setPrecioUnitario] = useState("");

    // Si estamos editando un artículo, llenar los campos con los datos actuales
    useEffect(() => {
        if (articuloActual) {
            setNombre(articuloActual.nombre);
            setPrecioUnitario(articuloActual.precioUnitario);
        } else {
            setNombre("");
            setPrecioUnitario("");
        }
    }, [articuloActual]);

    const manejarSubmit = (e) => {
        e.preventDefault();
        const articulo = { 
            name: nombre, 
            unitaryPrice: parseFloat(precioUnitario) };
        onGuardar(articulo);
    };

    return (
        <form onSubmit={manejarSubmit} className="mb-4 container">
            <h3>{articuloActual ? "Editar Artículo" : "Agregar Artículo"}</h3>
            <div className="form-group mx-2">
                <label>Nombre</label>
                <input
                    type="text"
                    className="form-control"
                    placeholder="Ingrese el nombre del artículo"
                    value={nombre}
                    onChange={(e) => setNombre(e.target.value)}
                    required
                />
            </div>
            <div className="form-group mx-2">
                <label>Precio Unitario</label>
                <input
                    type="number"
                    className="form-control"
                    placeholder="Ingrese el precio unitario"
                    value={precioUnitario}
                    onChange={(e) => setPrecioUnitario(e.target.value)}
                    required
                />
            </div>
            <button type="submit" className="btn btn-primary mx-2 mt-3">
                {articuloActual ? "Actualizar" : "Crear"}
            </button>
        </form>
    );
};

export default ArticuloForm;
