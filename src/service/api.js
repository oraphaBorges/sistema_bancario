import axios from 'axios';

export const api = axios.create({
    baseURL: 'https://gama-bankline-desbugados.herokuapp.com/'
});
