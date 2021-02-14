import { footer as Footer } from '../../components/index';
import { formsignup as Form } from '../../components/index';
import { nav as Nav } from '../../components/index';

import UserService from '../../../service/UserService';

import celularWhite from '../../../img/cell-white-bg.png';
import celularBlack from '../../../img/cell-black-bg.png';

let Home = {
  is_private: false,

  render: async () => {
      let view = `
        ${await Nav}
          <div id="bloco-cadastro-login" class="container bloco">
            ${blocoLogin}
            ${await Form}
          </div>
          <div id="bloco-celulares" class="bloco">
            ${blocoCelulares}
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

        if(element.id === 'cpf'){
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
    <a href="#/login"><button class="btn btn-md btn-rounded btn-gama">Acessar</button></a>
  </div>
`

let blocoCelulares=`
  <div class="bloco-item bloco-content-celular  bg-dark">
    <h1 class="text-gama text-center">CONTA DIGITAL</h1>
    <img src="${celularWhite}" alt="celular branco">
    <p class="text-gama">
      GamaAcademy Bank Line S.A. - CNPJ 00.000.000/0000-00 <br>
      Rua Fictícia, 999 - 00000-000 - São Paulo, SP <br>
      Este é um projeto de avaliação | GamaAcademy | Accenture | 2021
    </p>
  </div>
  <div class="bloco-item bloco-content-celular  bg-light">
    <h1 class="text-purple text-center">CARTÃO DE CRÉDITO</h1>
    <img src="${celularBlack}" alt="celular preto">
    <p>
      GamaAcademy Bank Line S.A. - CNPJ 00.000.000/0000-00 <br>
      Rua Fictícia, 999 - 00000-000 - São Paulo, SP <br>
      Este é um projeto de avaliação | GamaAcademy | Accenture | 2021
    </p>
  </div>
`

let blocoAnuidade=`
  <div class="bloco-item bloco-content-anuidade">
    <h2 class="text-light">Zero anuidade</h2>
    <p class="text-light">
      Burocracia custa caro. Somos eficientes<br>
      para você não ter que pagar tarifas.
    </p>
  </div>
  <div class="bloco-item bloco-content-anuidade text-center">
    <h1 class="text-gama">0,0</h2>
  </div>
`


export default Home;