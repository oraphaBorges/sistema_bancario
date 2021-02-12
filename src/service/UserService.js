import { api } from './api';
import { HeadersDefaultNoAuth , HeadersDefault} from './HeadersDefault';

import Utils from '../service/Utils';

const UserService = {
    register: async ({ cpf, login, nome, senha }) => {
        let temporary = {
            cpf: 85511573027,
            login: "emersonteste",
            nome: "Emerson Teste",
            senha: "emersonteste"
        }
        await api.post('/usuarios', temporary, HeadersDefaultNoAuth).then(r =>{
            console.log(r)
            Utils.redirect_to('login');

        }).catch(error => console.error(error));
    },

    doLogin: async({ usuario, senha }) => {
        let temporary = {
            usuario: "emersonteste",
            senha: "emersonteste"
        }
        await api.post('/login', temporary, HeadersDefaultNoAuth).then(response =>{
            console.log(response.data)
            // UserService.setDataInLocalStorage(response.data);
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

    newPassword: async ({ login, email }) => {
       let temporary = {
            email: "teste@teste.com",
            login: "emerson2"
        }
        await api.post('/nova-senha', temporary, HeadersDefaultNoAuth).then(response => {
            console.log(response);

        }).catch(({error}) =>{
            console.log(error)
        })

    },

    updatePassword: async ({ usuario, senha }) => {         
        let temporary = {
            senha: "emersonteste",
            usuario: "emersonteste"
        }
        
        const token = JSON.parse(localStorage.getItem('token'));
        await api.post('/altera-senha', temporary, HeadersDefault(token)).then(response => {
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

    //verificar como faremos com os dados recebidos
    setDataInLocalStorage: (data) => {
        let { token, usuario: { login }} = data;
        
        localStorage.setItem('token', JSON.stringify(token));
        localStorage.setItem('login', JSON.stringify(login));
    },   

}

export default UserService;