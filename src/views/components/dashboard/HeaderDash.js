import UserService from '../../../service/UserService';
import { dashboard as Dashboard } from '../../pages/index';

import logoutIcon from '../../../assets/img/svg/logout.svg';
import updateIcon from '../../../assets/img/svg/update.svg';

const HeaderDash = {
    render: (message = 'Mensagem do componente :)', id = 'main') => {
        let view = `   
            <div class="header-dash">
                <div id="text-wellcome">
                    <span class="text-white m-1 p-1">
                        ${message}
                    </span>
                    <span class="text-white m-1 p-1 date">
                        25 de janeiro de 2020
                    </span>
                </div>
                <img src="${updateIcon}" class="icon update" id="icon_update" value="${id}">
                <img src="${logoutIcon}" class="icon" id="icon_logout">
            </div>
        `;

        return view
    },

    after_render: () => {
        const logout = document.getElementById('icon_logout');
        logout.addEventListener('click', () => {
            UserService.doLogout();
        });

        const update = document.getElementById('icon_update');
        
        update.addEventListener('click', () => {
            const nextContent = update.getAttribute('value');
            Dashboard.after_render(nextContent);
        });
    }
}

export default HeaderDash;