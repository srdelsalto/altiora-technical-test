import axios from './axiosConfig';

export const obtenerArticulos = async () => {
    const response = await axios.get('/article');
    return response.data;
}

export const crearArticulo = async (articulo) => {
    const response = await axios.post('/article', articulo);
    return response.data;
}

