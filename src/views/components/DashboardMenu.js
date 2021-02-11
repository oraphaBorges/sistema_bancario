const DashboardMenu = {
    render: async () => {
        let menu = [];

        options.forEach(item => {
            let new_menu = getMenuItem(item.id, item.group);
            menu.push(new_menu);
        })

        let view = `
            ${ menu.join('') }
        `;

        return view
    },

    after_render: async () => {

    }
}

const options = [
    { id: 'home', group: 'Home' }, 
    { id: 'transactions', group: 'Transações', }, 
    { id: 'bankstatement', group: 'Extrato' }, 
    { id: 'accountplan', group: 'Planos de Conta' }
]

const getMenuItem = (id, group) => `
    <a href="${id}" id="${id}">
        <div class="card-menu--item bg-color--purple border-radius--5">
            <img src="./assets/img/svg/menu-item.svg" class="image-menu--item">
            <p>${group}</p>
        </div>
    </a>
`

export default DashboardMenu;