import { footer as Footer } from '../../components/index';

import logo from '../../../img/gama-academy-logo-horizontal-verde-branco.svg';

import UserService from '../../../service/UserService';

let Login = {
    render: async () => {
        let view = `
            ${html}
            ${await Footer}
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
<div class="">
  <div class="content-default">
    <img src="${logo}">
  </div>
  <div class="content-flex content-default content-justify">
      <div class="content-default content-flex">
        <form id="login_form">
          <input type="text" id="usuario" placeholder="Login de acesso" description="login">
          <input type="password" id="senha" placeholder="Digite sua senha" description="senha">
          <button id="button_submit" type="submit">Continuar</button>
        </form>
      </div>  
  </div>
</div>
`

export default Login;