import { UserService } from './service/UserService.js'

$(document).ready(function(){
  $('.cpf').mask('000.000.000-00', {reverse: true});
});

let data = {
  cpf: '32440909076',
  login: 'emersommmmmm',
  nome: 'emers',
  senha: '123123'
};

// UserService.register(data);

let data_login = {
  usuario: 'emersombra',
  senha: '123123'
};

// UserService.do_login(data_login);