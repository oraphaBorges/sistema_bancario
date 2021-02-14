import { api } from './api';
import { HeadersDefault } from './HeadersDefault';

const DashboardService = {

    getAccountData: async () => {
        let dataInicio = '2020-01-30';
        let dataFim = '2030-01-30';

        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        await api.get(`/dashboard?fim=${dataFim}&inicio=${dataInicio}&login=${login}`, HeadersDefault(token))
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

    setTransaction: async ({ operacao, planoConta, valor, origem_sigla, descricao, destino_sigla, destino_login } ) => {
        const token = JSON.parse(localStorage.getItem('token'));
        const login = JSON.parse(localStorage.getItem('login'));
        let response = false;

        let obj = {
            contaDestino: {
              login: destino_login ? destino_login: login,
              sigla: destino_sigla ? destino_sigla: origem_sigla
            },
            contaOrigem: {
              login: login,
              sigla: origem_sigla
            },

            date: new Date(),
            descricao: descricao,
            planoConta: planoConta,
            valor: Number(valor)
        }

        await api.post(`/lancamentos/?operacao=${operacao}`, obj, HeadersDefault(token)).then(response =>{
            response = true;
        }).catch(error => { 
            response = false;
        });  

        return true;
    },

    setAccountPlan: async ({ finalidade }) => {
        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        const data = { finalidade: finalidade, login: login }

        await api.post(`/lancamentos/planos-conta`, data, HeadersDefault(token)).then(response =>{
           console.log(response);
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
    },

    //retorna props: saldo e lancamentos[]
    getStatementByAccount: async ({ sigla }) => {
        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        const response = await api.get(`/conta/extrato?login=${login}&sigla=${sigla}`, HeadersDefault(token))
            .then(response => { return response.data })
            .catch(response => console.error(response));
        
        return response;
    },
    
    getStatementByPeriod: async ( { sigla, dataInicio = '2020-01-30', dataFim = '2030-01-30' }) => {
        const login = JSON.parse(localStorage.getItem('login'));
        const token = JSON.parse(localStorage.getItem('token'));

        const response = await api.get(`/conta/extrato-periodo?dataFim=${dataFim}&dataInicio=${dataInicio}&login=${temporaryLogin}&sigla=${temporarySigla}`, HeadersDefault(token))
            .then(response => console.log(response.data))
            .catch(error => Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Verifique os dados e tente novamente',
                footer: error
            }).then(()=>{
                location.reload();
            }))
        
        return response;
    },
}

export default DashboardService;