import { nav as Nav } from '../../components/index';

let ChangePassword = {
    is_private: true,

    render: async () => {
        let view = `
            ${ Nav }
            ${ html }
        `;

        return view
    },

    after_render: async () => {

    }
}

let html = `
<main class="card">
    <h2>Alteração de senha</h2>
    <form class="card-form">
        <input type="password" name="old_password" id="old_password" placeholder="Senha atual" required>
        <input type="password" name="new_password" id="new_password" placeholder="Nova senha" required>
        <button type="submit" class="btn btn-main-outline btn-rounded">Alterar</button>
    </form>
</main>
`

export default ChangePassword;