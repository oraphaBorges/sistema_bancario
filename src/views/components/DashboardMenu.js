import gamaHand from '../../assets/img/svg/gamahand.svg';
import iconHome from '../../assets/img/svg/home.svg';
import iconTransactions from '../../assets/img/svg/transactions.svg';
import iconBankstatement from '../../assets/img/svg/bankstatement.svg';
import iconAccountPlan from '../../assets/img/svg/accountplan.svg';

const DashboardMenu = {
    render: () => {
        let menu = [];

        menuOptions.forEach(option => {
            let new_menu = getMenuItem(option);
            menu.push(new_menu);
        })

        let view = `
            <nav class="dashboard-menu content-flex--column content-align--center bg-gama">
                <img src="${gamaHand}" alt="Gama hand">
                <div class="content-default">
                    ${ menu.join('') }
                </div>
            </nav>
        `;

        return view
    },

    after_render: () => { },
}

const menuOptions = [
    { id: 'main', group: 'Home', icon: iconHome, selected: false }, 
    { id: 'transactions', group: 'Transações', icon: iconTransactions, selected: false }, 
    { id: 'bankstatement', group: 'Extrato', icon: iconBankstatement, selected: false }, 
    { id: 'accountplan', group: 'Planos de Conta', icon: iconAccountPlan, selected: false }
]

const getMenuItem = ({ id, group, icon, selected }) => `
    <a id="${id}" class="menu-item">
        <div class="content-flex--column content-justify--between bg-purple card-menu--item ${ selected ? 'selected' : '' }">
            <img src="${icon}" class="icon-menu--default">
            <p>${group}</p>
        </div>
    </a>
`

export default DashboardMenu;