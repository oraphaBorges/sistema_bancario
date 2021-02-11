import { nav as Nav } from '../../components/index';

import UserService from '../../../service/UserService';

let Login = {
    is_private: false,

    render: async () => {
        let view = `
            ${await Nav}
            ${html}
        `;

        return view
    },

    after_render: async () => {
      Login.bindEvents();
    },

    bindEvents: async () => {
      const register_form = document.getElementById('login_form');
      register_form.addEventListener('submit', async (e) => {
          e.preventDefault();

          let data = { usuario: '', senha: '' };

          for(let i = 0; i < register_form.elements.length; i++){
              const element = register_form.elements[i];
              
              if(!element.value && element.id !== 'button_submit'){
                  alert(`Por gentileza, preencha o seguinte campo: ${element.getAttribute("description")}`);

                  return;
              }

              if(element.id !== 'button_submit')
                  data[element.id] = element.value;
          }

          UserService.doLogin(data);
      });
    }
}

let html = `
<main class="card">
<h2>Faça o seu Login</h2>
<form id="login_form" class="card-form">
    <input type="text" id="usuario" placeholder="Digite seu usuário">
    <input type="password" id="senha" placeholder="Digite sua senha">
    <button id="button_submit" type="submit" class="btn btn-main-outline btn-rounded">Entrar</button>
</form>
<a href="#/forgotpass">Esqueci minha senha</a>
<a href="#/signup.html">Ainda não sou cliente</a>
</main>
`

export default Login;