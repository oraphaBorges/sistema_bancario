import UserService from '../../../service/UserService';

import logoutIcon from '../../../assets/img/svg/logout.svg';
import updateIcon from '../../../assets/img/svg/update.svg';

const HeaderDash = {
    render: (message = 'Mensagem do componente :)') => {
        let view = `   
            <div class="header-dash content-default content-flex content-align--center">
                <div class="content-flex content-flex--1 content-justify--between">
                    <span class="text-white m-1 p-1">
                        ${message}
                    </span>
                    <span class="text-white m-1 p-1 date">
                        25 de janeiro de 2020
                    </span>
                </div>
                <img src="${updateIcon}" class="icon p-1 update" id="icon_update">
                <img src="${logoutIcon}" class="icon p-1" id="icon_logout">
            </div>
        `;

        return view
    },

    after_render: () => {
        const logout = document.getElementById('icon_logout');
        logout.addEventListener('click', () => {
            UserService.doLogout();
        });
    }
}

export default HeaderDash;