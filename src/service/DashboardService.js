import { api } from './api';
import { HeadersDefault } from './HeadersDefault';

import Utils from '../service/Utils';

const DashboardService = {

    getAccountData: async () => {
        let dataInicio = '2021-01-31';
        let dataFim = '2021-01-31';

        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        await api.get(`/dashboard?fim=${dataFim}&inicio=${dataInicio}&login=${login}`, HeadersDefault(token))
            .then(response => DashboardService.setDataInLocalStorage(response.data))
            .catch(response => console.error(response));
    },

    setDataInLocalStorage: (data) => {
        let { contaBanco, contaCredito } = data;

        localStorage.setItem('contaBanco', JSON.stringify(contaBanco));
        localStorage.setItem('contaCredito', JSON.stringify(contaCredito));
    },

    setTransaction: async() => {
        const token = JSON.parse(localStorage.getItem('token'));
        let transaction = {
            "conta": 1,
            "contaDestino": "user2",
            "data": "2021-01-01",
            "descricao": "PAGAMENTO CONTA LUZ",
            "login": "user1",
            "planoConta": 1,
            "valor": 10.12
        }
        await api.post(`/lancamentos`, transaction, HeadersDefault(token)).then(response =>{
           console.log(response)
        }).catch(error => console.error(error));  
    },
    setTransactionAccount: async() => {
        const token = JSON.parse(localStorage.getItem('token'));
        let transactionAccount = {
            "descricao": "string",
            "id": 0,
            "login": "string",
            "padrao": true,
            "tipoMovimento": "R"
        }
        await api.post(`/lancamentos/planos-conta`, transactionAccount, HeadersDefault(token)).then(response =>{
           console.log(response)
        }).catch(error => console.error(error));  
    },
    getPlanAccount: async()=> {
        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        await api.get(`/lancamentos/planos-conta?&login=${login}`, HeadersDefault(token)).then(response => {
            console.log(response)
        })
    }
}

export default DashboardService;