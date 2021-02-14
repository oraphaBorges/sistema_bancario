import { nav as Nav } from '../../components/index';
import UserService from './../../../service/UserService';

const ForgotPassword = {
    is_private: false,

    render: async () => {
        let view = `
            ${ Nav }
            ${ html }
        `;

        return view
    },

    after_render: async () => {
        ForgotPassword.bindEvents();
    },

    bindEvents: () => {
        const form_forgot = document.getElementById('form_forgot');
        form_forgot.addEventListener('submit', async (e) => {
            e.preventDefault();
  
            let data = { login: '' };
  
            for(let i = 0; i < form_forgot.elements.length; i++){
                  const element = form_forgot.elements[i]; 
                  data[element.id] = element.value;
            }
                        
            await UserService.newPassword(data);
        });
    }
}

let html = `
<main class="card">
    <h2>Esqueci minha senha</h2>
    <form class="card-form" id="form_forgot">
        <p>Digite seu login cadastrado</p>
        <input type="texto" name="conta" id="login" placeholder="Digite seu login" required>
        <small>Enviaremos o link de recuperação de senha</small>
        <button type="submit" class="btn btn-main-outline btn-rounded">Enviar</button>
    </form>
    <a href="#/login">Fazer Login</a>
    <a href="#/">Ainda não sou cliente</a>
</main>
`

export default ForgotPassword;