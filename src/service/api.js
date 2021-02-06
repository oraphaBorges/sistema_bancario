import axios from 'axios';

export const api = axios.create({
    baseURL: 'https://gama-bankline-desbugados.herokuapp.com/'
    // baseURL: 'https://webhook.site/5bf865a1-9275-4dfa-9f24-6da2595a9c3c'

});

//Inserir cada componente dentro de outro render