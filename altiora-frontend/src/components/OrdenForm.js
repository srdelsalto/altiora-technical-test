import React, { useState, useEffect } from "react";
import { obtenerClientes } from "../services/ClienteService";
import { obtenerArticulos } from "../services/ArticuloService";

const OrdenForm = ({ ordenActual, onGuardar }) => {
    const [clientes, setClientes] = useState([]);
    const [articulos, setArticulos] = useState([]);
    const [clienteId, setClienteId] = useState("");
    const [fecha, setFecha] = useState("");
    const [articulosSeleccionados, setArticulosSeleccionados] = useState([]);

    // Cargar clientes y artículos al montar el componente
    useEffect(() => {
        cargarClientes();
        cargarArticulos();
    }, []);

    // Si estamos editando una orden, llenar los campos con los datos actuales
    useEffect(() => {
        if (ordenActual) {
            setClienteId(ordenActual.clienteId);
            setFecha(ordenActual.fecha);
            setArticulosSeleccionados(ordenActual.articulos.map((articulo) => articulo.id));
        } else {
            setClienteId("");
            setFecha("");
            setArticulosSeleccionados([]);
        }
    }, [ordenActual]);

    const cargarClientes = async () => {
        const datosClientes = await obtenerClientes();
        setClientes(datosClientes);
    };

    const cargarArticulos = async () => {
        const datosArticulos = await obtenerArticulos();
        setArticulos(datosArticulos);
    };

    const manejarCheckboxChange = (articuloId) => {
        if (articulosSeleccionados.includes(articuloId)) {
            setArticulosSeleccionados(articulosSeleccionados.filter((id) => id !== articuloId));
        } else {
            setArticulosSeleccionados([...articulosSeleccionados, articuloId]);
        }
    };

    const manejarSubmit = (e) => {
        e.preventDefault();
        const nuevaOrden = {
            clientId: clienteId,
            date: fecha,
            articleIds: articulosSeleccionados
        };
        onGuardar(nuevaOrden);
        setClienteId("");
        setFecha("");
        setArticulosSeleccionados([]);
    };

    return (
        <form onSubmit={manejarSubmit} className="container">
            <h3>{ordenActual ? "Editar Orden" : "Crear Orden"}</h3>

            {/* Selección de la Fecha */}
            <div className="form-group m-2">
                <label>Fecha</label>
                <input
                    type="date"
                    className="form-control"
                    value={fecha}
                    onChange={(e) => setFecha(e.target.value)}
                    required
                />
            </div>

            {/* Selección del Cliente */}
            <div className="form-group m-2">
                <label>Cliente</label>
                <select
                    className="form-control"
                    value={clienteId}
                    onChange={(e) => setClienteId(e.target.value)}
                    required
                >
                    <option value="">Seleccione un cliente</option>
                    {clientes.map((cliente) => (
                        <option key={cliente.id} value={cliente.id}>
                            {cliente.firstName} {cliente.lastName}
                        </option>
                    ))}
                </select>
            </div>

            {/* Selección de los Artículos */}
            <div className="form-group m-2">
                <label>Artículos</label>
                {articulos.map((articulo) => (
                    <div className="form-check" key={articulo.id}>
                        <input
                            type="checkbox"
                            className="form-check-input"
                            id={`articulo-${articulo.id}`}
                            checked={articulosSeleccionados.includes(articulo.id)}
                            onChange={() => manejarCheckboxChange(articulo.id)}
                        />
                        <label className="form-check-label" htmlFor={`articulo-${articulo.id}`}>
                            {articulo.name} - ${articulo.unitaryPrice}
                        </label>
                    </div>
                ))}
            </div>

            <button type="submit" className="btn btn-primary mx-2 mt-1 mb-2">
                {ordenActual ? "Actualizar" : "Crear"}
            </button>
        </form>
    );
};

export default OrdenForm;
