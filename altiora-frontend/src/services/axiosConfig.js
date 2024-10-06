import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8080/api', // Cambia esto a la URL de tu API
    timeout: 10000, // Timeout de 10 segundos
    headers: {
        'Content-Type': 'application/json',
        'Accept': '*/*',
    },
});

export default axiosInstance;
