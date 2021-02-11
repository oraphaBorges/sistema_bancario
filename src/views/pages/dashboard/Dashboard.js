import { footer as Footer, dashboardMenu as DashboardMenu } from '../../components/index';

const Dashboard = {
    is_private: true,
    
    render: async () => {
        let view = `
            <div class="content-flex">
                ${ DashboardMenu }
                ${ html }
            </div>
        `;

        return view
    },

    after_render: async () => {
        Dashboard.bindEvents();
        Dashboard.insertDashboardContent('home');
        // DashboardService.getAccountData();
    },

    insertDashboardContent: (idContent) => {
        //buscar conteúdo de acordo com o id passado para essa função.
        //inserir funcionalidade que muda o conteúdo sem mexer na barra lateral
        const dashboard_content = document.getElementById('dashboard_content');

        dashboard_content.innerHTML = `<h2>Novo conteúdo</h2> + ${idContent}`;
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
<div id="dashboard_content">
    <h1>hehehe</h1>
</div>
`

export default Dashboard;