import { footer as Footer } from '../../components/index';
import DashboardService from '../../../service/DashboardService';


const Dashboard = {
    is_private: true,
    
    render: async () => {
        let view = `
            ${html}
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {
        DashboardService.getAccountData();
    }
}

let html = 
`
    <h1>Here is Dashboard page :)</h1>
    <h2>only view propose<h2>

    ${JSON.parse(localStorage.getItem('contaBanco'))}
    ${JSON.parse(localStorage.getItem('contaCredito'))}
    ${localStorage.getItem('contaBanco')}
    ${localStorage.getItem('contaCredito')}

`

export default Dashboard;