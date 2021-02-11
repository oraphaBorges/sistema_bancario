import { footer as Footer } from '../../components/index';
import { formsignup as Form } from '../../components/index';
import { nav as Nav } from '../../components/index';

import UserService from '../../../service/UserService';

let Home = {
  is_private: false,

  render: async () => {
      let view = `
        ${await Nav}
        <div class="container-width--full container-height--full bg-color--purple">  
          <div class="content-flex content-default content-justify">
          ${await Form}
          </div>
          ${html}
        </div>
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

let html =
`    <div class="container-width--full container-height--full bg-color--grey">
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

`

export default Home;