import { nav as Nav } from '../../components/index';

let ForgotPassword = {
    is_private: false,

    render: async () => {
        let view = `
            ${await Nav}
            ${html}
        `;

        return view
    },

    after_render: async () => {

    }
}

let html = `
<main class="card">
    <h2>Esqueci minha senha</h2>
    <form class="card-form">
        <p>Digite sua conta cadastrada</p>
        <input type="texto" name="conta" id="field-conta" placeholder="Digite sua conta" required>
        <small>Enviaremos o link de recuperação de senha</small>
        <button type="submit" class="btn btn-main-outline btn-rounded">Enviar</button>
    </form>
    <a href="./login.html">Fazer Login</a>
    <a href="./singnup.html">Ainda não sou cliente</a>
</main>
`

export default ForgotPassword;