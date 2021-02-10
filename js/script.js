import { UserService } from './service/UserService.js';

const register_form = document.getElementById('register-account');

if(register_form){
  $(document).ready(function(){
    $('.cpf').mask('000.000.000-00', {reverse: true});
  });
  
  register_form.addEventListener('submit', e => {
    e.preventDefault();
  
    const button = document.getElementById('register-new-account');
    const buttonText = document.getElementById('button-text');
    buttonText.innerHTML = 'Carregando...';
    button.disabled = true;
  
    let data = { cpf: '', login: '', nome: '', senha: '' };
  
    for(let i = 0; i < register_form.elements.length; i++) {
      const element = register_form.elements[i];
  
      if(!element.value && element.id !== 'register-new-account'){
        alert(`Por gentileza, preencha o seguinte campo: ${element.getAttribute("description")}`);
        buttonText.innerHTML = 'Continuar';
        button.disabled = false;
  
        return;
      }
  
      if(element.id !== 'confirmar_senha' && element.id !== 'register-new-account')
        data[element.id] = element.value;
  
    }
    
    data.cpf = data.cpf.replace(/[.,\/#!$%\^&\*;:{}=\-_`~()]/g,'');
  
    setTimeout(async () => {
      await UserService.register(data);
    }, 1000);
  })

}

const login_form = document.getElementById('login-form');

if(login_form){
  login_form.addEventListener('submit', e => {
    e.preventDefault();
  
    const button = document.getElementById('button_submit');
    button.innerHTML = 'Carregando...';
    button.disabled = true;
  
    let data = { usuario: '', senha: '' };
  
    for(let i = 0; i < login_form.elements.length; i++) {
      const element = login_form.elements[i];
  
      if(!element.value && element.id !== 'button_submit'){
        alert(`Por gentileza, preencha o seguinte campo: ${element.getAttribute("description")}`);
        button.innerHTML = 'Entrar';
        button.disabled = false;
  
        return;
      }
  
      if(element.id !== 'button_submit')
        data[element.id] = element.value;
  
    }

    setTimeout(async () => {
      await UserService.do_login(data);

      button.innerHTML = 'Entrar';
      button.disabled = false;

    }, 1000);
  })

}