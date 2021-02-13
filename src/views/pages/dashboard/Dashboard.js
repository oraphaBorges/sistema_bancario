import DashboardService from '../../../service/DashboardService';

import { dashboardMenu as Menu, main as Main, accountPlan as AccountPlan, transaction as Transaction } from '../../components/index';

const Dashboard = {
    is_private: true,
    components: [
        { id: 'main', component: Main },
        { id: 'transactions', component: Transaction },
        { id: 'bankstatement', component: 'OtherImplement' },
        { id: 'accountplan', component: AccountPlan }
    ],
    
    render: async () => {
        let view = `
            <div class="content-flex">
                ${ Menu }
                ${ html }
            </div>
        `;

        return view
    },

    after_render: async () => {
        Dashboard.bindEvents();
        await DashboardService.getAccountData();
        await DashboardService.getAccountPlan();
        Dashboard.insertDashboardContent('main');
    },

    insertDashboardContent: (idContent) => {
        const { component } = Dashboard.components.find(component => component.id === idContent);
        const dashboard_content = document.getElementById('content-dashboard');
        
        dashboard_content.innerHTML = `${ component.render() }`;
        component.after_render();
    },

    bindEvents: () => {
        const menu_options = document.querySelectorAll('a.menu-item');
        menu_options.forEach(menuItem => {
            menuItem.addEventListener('click', () => Dashboard.insertDashboardContent(menuItem.id))
        });
    }
}

let html = 
`
<div id="content-dashboard" class="content-dashboard">
</div>
`

export default Dashboard;