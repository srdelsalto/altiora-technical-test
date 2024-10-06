import axios from './axiosConfig';

export const obtenerOrdenes = async () => {
    const response = await axios.get('/order');
    console.log(response.data);
    return response.data;
};

export const crearOrden = async (orden) => {
    console.log(orden);
    const response = await axios.post('/order', orden);
    return response.data;
};