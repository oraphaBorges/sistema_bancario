import { nav as Nav } from '../../components/index';
import UserService from './../../../service/UserService';

const ChangePassword = {
    is_private: true,

    render: async () => {
        let view = `
            ${ Nav }
            ${ html }
        `;

        return view
    },

    after_render: async () => {
        ChangePassword.bindEvents();
    },

    bindEvents: () => {
        const form_change = document.getElementById('form_change');
        form_change.addEventListener('submit', async (e) => {
            e.preventDefault();
  
            let data = { senha: '' };
  
            for(let i = 0; i < form_change.elements.length; i++){
                  const element = form_change.elements[i]; 
                  data[element.id] = element.value;
            }
                        
            await UserService.updatePassword(data);
        });
    }
}

let html = `
<main class="card">
    <h2>Alteração de senha</h2>
    <form class="card-form" id="">
        <input type="password" name="old_password" id="old_password" placeholder="Senha atual" required>
        <input type="password" name="new_password" id="new_password" placeholder="Nova senha" required>
        <button type="submit" class="btn btn-main-outline btn-rounded">Alterar</button>
    </form>
</main>
`

export default ChangePassword;