import axios from './axiosConfig'

export const obtenerClientes = async () => {
    const response = await axios.get('/clients');
    return response.data;
};

export const crearCliente = async (cliente) => {
    const response = await axios.post('/clients', cliente);
    return response.data;
};

export const actualizarCliente = async (cliente) => {
    const response = await axios.put('/clients', cliente);
    return response.data;
};

export const eliminarCliente = async (clienteId) => {
    const response = await axios.delete(`/clients?id=${clienteId}`);
    return response.data;
};
