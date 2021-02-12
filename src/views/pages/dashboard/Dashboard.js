import { dashboardMenu as Menu, main as Main } from '../../components/index';

const Dashboard = {
    is_private: true,
    components: [
        { id: 'main', component: Main },
        { id: 'transactions', component: 'implementar' },
        { id: 'bankstatement', component: 'OtherImplement' },
        { id: 'accountplan', component: 'nextImplement' }
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
        Dashboard.insertDashboardContent('main');
        // DashboardService.getAccountData();
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