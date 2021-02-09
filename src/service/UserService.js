import { api } from './api';
import { headersDefaultNoAuth, headersDefault } from './headersDefault';

import Utils from '../service/Utils';

const UserService = {
    register: async (data) => {
        await api.post('/usuarios', data, headersDefaultNoAuth).then(response =>{
            Utils.redirect_to('dashboard');

        }).catch(response => console.error(response));
    },

    do_login: async(data) => {
        await api.post('/login', data, headersDefaultNoAuth).then(response =>{
            let { token, usuario, conta, contaCredito } = response.data
            localStorage.setItem('token', JSON.stringify(token));
            localStorage.setItem('usuario', JSON.stringify(usuario));
            localStorage.setItem('conta', JSON.stringify(conta));
            localStorage.setItem('contaCredito', JSON.stringify(contaCredito));
            Utils.redirect_to('dashboard');

        }).catch(response => {
            console.error(response);
        });
    },

    do_logout: async(data) => {
        await api.post('/VERIFICAR', data, headersDefault(data)).then(response =>{
            localStorage.clear();
            Utils.redirect_to('/');

        }).catch(response => console.error(response));
    }
    
}

export default UserService;