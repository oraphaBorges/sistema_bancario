import { api } from './api';
import { HeadersDefault } from './HeadersDefault';

const DashboardService = {

    getAccountData: async () => {
        let dataInicio = '2020-01-31';
        let dataFim = '2022-01-31';
        let temporaryLogin = 'emersonteste';

        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        await api.get(`/dashboard?fim=${dataFim}&inicio=${dataInicio}&login=${temporaryLogin}`, HeadersDefault(token))
            .then(response => DashboardService.setAccountDataIntoLocalStorage(response.data))
            .catch(response => console.error(response));
    },

    setAccountDataIntoLocalStorage: (data) => {
        const CONTA_CORRENTE = data.find(conta => conta.tipo === 'CORRENTE');
        const CONTA_POUPANCA = data.find(conta => conta.tipo === 'POUPANCA');
        const CONTA_CREDITO = data.find(conta => conta.tipo === 'CREDITO');

        localStorage.setItem('CONTA_CORRENTE', JSON.stringify(CONTA_CORRENTE));
        localStorage.setItem('CONTA_POUPANCA', JSON.stringify(CONTA_POUPANCA));
        localStorage.setItem('CONTA_CREDITO', JSON.stringify(CONTA_CREDITO));
    },

    setTransaction: async () => {
        const token = JSON.parse(localStorage.getItem('token'));
        let temporary = {
            contaDestino: {
              login: "emersonteste",
              sigla: "POUPANCA"
            },
            contaOrigem: {
              login: "emersonteste",
              sigla: "POUPANCA"
            },

            date: "2020-12-12",
            descricao: "Compra de fruta",
            planoConta: "DEPOSITO",
            valor: 107.3
        }

        let temporaryOperation = 'DEPOSITO';

        await api.post(`/lancamentos/?operacao=${temporaryOperation}`, temporary, HeadersDefault(token)).then(response =>{
           console.log(response)
        }).catch(error => console.error(error));  
    },

    setAccountPlan: async () => {
        const token = JSON.parse(localStorage.getItem('token'));
        let temporary = {
            finalidade: "NOVADENOVO",
            login: "emersonteste"
        }

        await api.post(`/lancamentos/planos-conta`, temporary, HeadersDefault(token)).then(response =>{
           console.log(response)
        }).catch(error => console.error(error));  
    },

    getAccountPlan: async () => {
        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));
        let temporary = "emersonteste"

        await api.get(`/lancamentos/planos-conta/?login=${temporary}`, HeadersDefault(token)).then(response => {
            let PLANOS_CONTA = response.data.map(item => item.finalidade);
            localStorage.setItem('PLANOS_CONTA', JSON.stringify(PLANOS_CONTA));
        })
    }
}

export default DashboardService;