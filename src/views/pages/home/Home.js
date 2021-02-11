import { footer as Footer } from '../../components/index';
import { formsignup as Form } from '../../components/index';
import { nav as Nav } from '../../components/index';

import UserService from '../../../service/UserService';

let Home = {
  is_private: false,

  render: async () => {
      let view = `
        ${await Nav}
          <div class="container bloco">
          ${blocoLogin}
          ${await Form}
          </div>
          ${html}
        ${await Footer}
      `;

      return view
  },

  after_render: async () => {
    const register_form = document.getElementById('register_form');

    register_form.addEventListener('submit', async (e) => {
      e.preventDefault();
      
      let data = { cpf: '', login: '', nome: '', senha: '' };

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

      await UserService.register(data);
    });
  }
}

let blocoLogin = `
  <div class="bloco-item bloco-content-login">
      <h2>Gama Bank</h2>
      <p>é um projeto de nossos alunos.</p>
      <p>Já tem conta?</p>
      <button class="btn btn-md btn-rounded btn-gama">Acessar</button>
  </div>
`

let html =
`    <div class="container-width--full container-height--full bg-grey">
      <div class="content-default content-flex">
        <div class="flex-wrap container-height--full container-width--full">img 1</div>
        <div class="flex-wrap container-height--full container-width--full">img 2</div>
      </div>
    </div>
    <div class="container-width--full container-height--full bg-purple">
      <div class="content-flex container-height--full container-width--full">
        <div class="flex-wrap">Div1</div>
        <div class="flex-wrap">Dvi2</div>
      </div>
    </div>
    <div class="container-width--full container-height--full bg-green">
      <div class="content-default content-flex">
        <p>text 1</p>
      </div>
    </div>
    <div class="container-width--full container-height--full bg-grey">
    <div class="content-flex container-height--full container-width--full">
      <div class="flex-wrap">Div1</div>
      <div class="flex-wrap">Dvi2</div>
    </div>

`

export default Home;