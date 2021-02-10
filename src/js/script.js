import { UserService } from './service/UserService.js'

$(document).ready(function(){
  $('.cpf').mask('000.000.000-00', {reverse: true});
});

const register_form = document.getElementById('register-account');

if(register_form){
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


let data_login = {
  usuario: 'emersombra',
  senha: '123123'
};

// UserService.do_login(data_login);