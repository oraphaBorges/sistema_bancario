const BASE_URL = 'https://gama-bankline-desbugados.herokuapp.com/';
const METHODS = { POST: 'POST', PUT: 'PUT' };
const CONTENT_TYPE = 'application/json';
const HeadersDefault = {
    headersNoAuth: {
        'Accept': 'application/json',
        'Content-Type': CONTENT_TYPE
    }
}      

export const UserService = {
    register: async ({ cpf, login, nome, senha }) => await fetch(`${BASE_URL}usuarios`, {
        method: METHODS.POST,
        body: JSON.stringify({ cpf, login, nome, senha }),
        headers: HeadersDefault.headersNoAuth

    }).then(response => {
        let res = '';

        if(response.status === 201){
            res = response.json();
            location.replace('login.html');
        }

        if(response.status === 400)
            res = 'Ocorreu um erro. Por gentileza, tente mais tarde.';

        if(response.status === 406)
            res = 'Usuário já cadastrado no sistema';

        return res;

    }).catch(error => console.error(error)),

    do_login: async ( {usuario, login} ) => await fetch(`${BASE_URL}login`, {
        method: METHODS.POST,
        body: JSON.stringify({ usuario, login }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': CONTENT_TYPE
        }

    }).then(response => {
        if(response.status === 202){
            let { token, login } = response;

            localStorage.setItem('token', JSON.stringify(token));
            localStorage.setItem('login', JSON.stringify(login));

            location.replace('dashboard.html');
        }

        if(response.status === 400)
            return 'Usuário ou senha inválida';

        return 'Ocorreu um erro. Tente novamente mais tarde';

    }).catch(error => console.error(error)),
}
