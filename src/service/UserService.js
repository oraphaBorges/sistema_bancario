import { api } from './api';
import { HeadersDefaultNoAuth , HeadersDefault} from './HeadersDefault';

import Utils from '../service/Utils';

const UserService = {
    register: async (data) => {
        await api.post('/usuarios', data, HeadersDefaultNoAuth).then(r =>{
            Utils.redirect_to('login');

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

    newPassword: async () => {
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
    // Esta dando erro 500
    updatePassword: async () => {         
        let postAlterarSenha = {
            senha: "123456",
            usuario: "rafael10"
        }
        const token = JSON.parse(localStorage.getItem('token'));
        const parametroTeste = "12#fort";
        await api.post(`/altera-senha?senhaTemporaria=${parametroTeste}`, postAlterarSenha, HeadersDefault(token)).then(response => {
            console.log(response);

        }).catch(error => {
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