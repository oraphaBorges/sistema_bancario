import { footer as Footer } from '../../components/index';

import logo from '../../../img/gama-academy-logo-horizontal-verde-branco.svg';

import UserService from '../../../service/UserService';

let Home = {
    render: async () => {
        let view = `${html}
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {
      const register_form = document.getElementById('register_form');

      register_form.addEventListener('submit', async (e) => {
        e.preventDefault();
        
        let data = {
          cpf: '',
          login: '',
          nome: '',
          senha: ''
        };

        for(let i = 0; i < register_form.elements.length; i++) {
          const element = register_form.elements[i];

          if(!element.value && element.id !== 'button_submit'){
            alert(`Por gentileza, preencha o seguinte campo: ${element.getAttribute("description")}`);

            return;
          }

          if(element.id === 'CPF'){
            //criar função util de validar CPF;
          }

          if(element.id !== 'confirmar_senha' && element.id !== 'button_submit')
            data[element.id] = element.value;

        }

        const response = await UserService.register(data);
      });
    }
}

let html = `
<div class="container-width--full container-height--full bg-color--purple">
  <div class="content-default">
    <img src="${logo}">
  </div>
  <div class="content-flex content-default content-justify">
      <div class="content-default content-flex">
        <form id="register_form">
          <input type="text" id="cpf" placeholder="CPF" description="CPF">
          <input type="text" id="nome" placeholder="Nome Completo" description="nome completo">
          <input type="text" id="login" placeholder="Login de acesso" description="login de acesso">
          <input type="password" id="senha" placeholder="Digite sua senha" description="senha">
          <input type="password" id="confirmar_senha" placeholder="Confirme sua senha" description="confirmar senha">
          <button id="button_submit" type="submit">Continuar</button>
        </form>
      </div>  
  </div>
  </div>
  <div class="container-width--full container-height--full bg-color--grey">
    <div class="content-default content-flex">
      <div class="flex-wrap container-height--full container-width--full">img 1</div>
      <div class="flex-wrap container-height--full container-width--full">img 2</div>
    </div>
  </div>
  <div class="container-width--full container-height--full bg-color--purple">
    <div class="content-flex container-height--full container-width--full">
      <div class="flex-wrap">Div1</div>
      <div class="flex-wrap">Dvi2</div>
    </div>
  </div>
  <div class="container-width--full container-height--full bg-color--green">
    <div class="content-default content-flex">
      <p>text 1</p>
    </div>
  </div>
  <div class="container-width--full container-height--full bg-color--grey">
  <div class="content-flex container-height--full container-width--full">
    <div class="flex-wrap">Div1</div>
    <div class="flex-wrap">Dvi2</div>
  </div>
</div>
`

export default Home;