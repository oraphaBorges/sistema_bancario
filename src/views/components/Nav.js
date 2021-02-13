import Logo from '../../assets/img/logo-gama.svg';
let Nav = {
    render: () => {
        let view = `
        <nav class="nav container">
            <a class="logo" href="#">
                <img class="nav-logo" src="${Logo}" alt="logo">
            </a>
        </nav>
        `;

        return view
    },

    after_render: async () => {

    }
}

export default Nav;