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
    }
}

export default DashboardService;