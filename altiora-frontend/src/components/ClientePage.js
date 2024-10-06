import React, { useEffect, useState } from "react";
import { obtenerClientes, crearCliente, eliminarCliente, actualizarCliente } from "../services/ClienteService";
import { obtenerOrdenes, crearOrden } from "../services/OrdenService";
import { obtenerArticulos, crearArticulo } from "../services/ArticuloService";
import ClienteForm from "./ClienteForm";
import ClienteList from "./ClienteList";
import OrdenForm from "./OrdenForm";
import OrdenList from "./OrdenList";
import ArticuloForm from "./ArticuloForm";
import ArticuloList from "./ArticuloList";
import Swal from 'sweetalert2'

const ClientePage = () => {
    const [clientes, setClientes] = useState([]);
    const [ordenes, setOrdenes] = useState([]);
    const [articulos, setArticulos] = useState([]);
    const [clienteActual, setClienteActual] = useState(null);
    const [ordenActual, setOrdenActual] = useState(null);
    const [articuloActual, setArticuloActual] = useState(null);

    useEffect(() => {
        cargarClientes();
        cargarOrdenes();
        cargarArticulos();
    }, []);

    const cargarClientes = async () => {
        const datosClientes = await obtenerClientes();
        setClientes(datosClientes);
    };

    const cargarOrdenes = async () => {
        const datosOrdenes = await obtenerOrdenes();
        setOrdenes(datosOrdenes);
    };

    const cargarArticulos = async () => {
        const datosArticulos = await obtenerArticulos();
        setArticulos(datosArticulos);
    };

    const guardarCliente = async (cliente) => {
        if (cliente.id) {
            await actualizarCliente(cliente);
        }else{
            await crearCliente(cliente);
        }

        cargarClientes(); // Actualizamos la lista
        setClienteActual(null); // Limpiamos el formulario
    };

    const editClient = (cliente) => {
        setClienteActual(cliente);
    }

    const deleteClient = async (clienteId) => {
        const response = await eliminarCliente(clienteId);

        if (response.message === "Client deleted") {
            Swal.fire({
                title: 'Cliente eliminado',
                icon: 'success',
                confirmButtonText: 'Ok'
            });
        }else{
            Swal.fire({
                title: 'Error al eliminar el cliente',
                icon: 'error',
                confirmButtonText: 'Ok'
            });
        }


        cargarClientes();
    }

    const guardarOrden = async (orden) => {
        await crearOrden(orden);
        cargarOrdenes();
    };

    const guardarArticulo = async (articulo) => {
        await crearArticulo(articulo);
        cargarArticulos();
    };

    return (
        <div>
            <h2 className="text-center">Gestión de Clientes</h2>
            <ClienteForm clienteActual={clienteActual} onGuardar={guardarCliente} />
            <ClienteList clientes={clientes} onEliminar={deleteClient} onEditar={editClient} />

            <h2 className="text-center">Gestión de Órdenes</h2>
            <OrdenForm ordenActual={ordenActual} onGuardar={guardarOrden} />
            <OrdenList ordenes={ordenes} />

            <h2 className="text-center">Gestión de Artículos</h2>
            <ArticuloForm articuloActual={articuloActual} onGuardar={guardarArticulo} />
            <ArticuloList articulos={articulos} />
        </div>
    );
};

export default ClientePage;
