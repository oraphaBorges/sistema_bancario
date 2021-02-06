import { footer as Footer } from '../../components/index';

import logo from '../../../img/gama-academy-logo-horizontal-verde-branco.svg';

let Home = {
    render: async () => {
        let view = `${html}
            
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

let html = `
<div class="container-width--full container-height--full bg-color--purple">
<div class="content-default">
  <img src="${logo}">
</div>
<div class="content-flex content-default content-justify content-wrap">
    <a href="#/dashboard">Dashboard</a>
    <a href="#/usuarios">Criar usuario</a>
    <a href="#/login">Realize login</a>
    <a href="#/nova-senha">Nova senha</a>
    <a href="#/altera-senha">Alterar senha</a>
    <a href="#/lancamentos">Lançamentos</a>
    <div class="">
      texto
    </div>
    <div class="">
      <form action="">
        <input type="text">
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