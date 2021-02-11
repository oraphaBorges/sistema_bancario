import { api } from './api';
import { HeadersDefaultNoAuth } from './HeadersDefault';

import Utils from '../service/Utils';

const UserService = {
    register: async (data) => {
        await api.post('/usuarios', data, HeadersDefaultNoAuth).then(response =>{
            UserService.setDataInLocalStorage(response.data);
            Utils.redirect_to('dashboard');

        }).catch(error => console.error(error));
    },

    doLogin: async(data) => {
        await api.post('/login', data, HeadersDefaultNoAuth).then(response =>{
            UserService.setDataInLocalStorage(response.data);
            Utils.redirect_to('dashboard');
           
        })
        .catch(({ response }) => {
            let { codigo, status, error } = response.data;

            if(codigo === "999" && status === 409){
                alert(error);
                location.reload();
            }
        });
    },

    updatePassword: async () => {
       let postSenha = {
            email: "teste@teste.com",
            login: "emerson2"
        }
        await api.post('/nova-senha', postSenha, HeadersDefaultNoAuth).then(response => {
            console.log(response);

        }).catch(({error}) =>{
            console.log(error)
        })

    },


    doLogout: () => {
        localStorage.clear();

        Utils.redirect_to('/');
    },

    isUserLogged: () => {
        let response = true;
        
        const token = JSON.parse(localStorage.getItem('token'));

        if (!token){
            Utils.redirect_to('login');
            response = false;
        }

        return response;
    },

    setDataInLocalStorage: (data) => {
        let { token, usuario: { login }} = data;
        
        localStorage.setItem('token', JSON.stringify(token));
        localStorage.setItem('login', JSON.stringify(login));
    },   

}

export default UserService;