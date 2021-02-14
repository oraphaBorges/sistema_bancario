/** Imports **/
import Utils from '../src/service/Utils';

/** User service**/
import UserService from './service/UserService';

/** Pages **/
import { error404, home, login, forgotPassword, changePassword, dashboard } from './views/pages/index';

/** Routes **/
let routes = {
    '/': home,
    '/login': login,
    '/new-password': forgotPassword,
    '/change-password': changePassword,
    '/dashboard': dashboard
}

const router = async () => {
    const root = document.getElementById('root');

    let request = Utils.parseRequestURL();

    let parseURL = (request.resource ? '/' + request.resource : '/') + (request.id ? '/:id' + request.id : '') + (request.verb ? '/' + request.verb : '');
    let page = routes[parseURL] ? routes[parseURL] : error404;

    if(page.is_private === true && !UserService.isUserLogged())
        return;

    root.innerHTML = await page.render();
    await page.after_render();
}

/**observa mudanças na hash*/
window.addEventListener('hashchange', router);

/**oberva carregamento da pagina */
window.addEventListener('load', router);
