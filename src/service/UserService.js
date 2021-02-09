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
            let { token, ...userData } = response.data;
            localStorage.setItem('token', JSON.stringify(token));
            localStorage.setItem('userData', JSON.stringify(userData));

            Utils.redirect_to('dashboard');

        }).catch(response => {
            console.error(response);
        });
    },

    do_logout: () => {
            localStorage.clear();

            Utils.redirect_to('/');
    }
    
}

export default UserService;