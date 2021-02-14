import { nav as Nav } from '../../components/index';

let ForgotPassword = {
    is_private: false,

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
    <h2>Esqueci minha senha</h2>
    <form class="card-form">
        <p>Digite seu login cadastrado</p>
        <input type="texto" name="conta" id="field-conta" placeholder="Digite seu login" required>
        <small>Enviaremos o link de recuperação de senha</small>
        <button type="submit" class="btn btn-main-outline btn-rounded">Enviar</button>
    </form>
    <a href="#/login">Fazer Login</a>
    <a href="#/">Ainda não sou cliente</a>
</main>
`

export default ForgotPassword;