let FormSignup = {
    render: () => {
        let view = `
        <div class="card bloco-item">
            <h2>Faça o seu Cadastro</h2>
            <p class="text-left">Preencha seus dados para realizar seu cadastro</p>
            <form id="register_form" class="card-form">
                <input id="cpf"   class="input" type="text" placeholder="CPF" required>
                <input id="nome"  class="input" type="text" placeholder="Nome completo" required>
                <input id="login" class="input" type="text" placeholder="Login de acesso" required>
                <input id="senha" class="input" type="password" placeholder="Digite sua senha" required>
                <input id="confirmar_senha" class="input" type="password" placeholder="Confirme sua senha" required>
                <button id="button_submit" type="submit" class="btn btn-main-outline btn-rounded">Continuar</button>
            </form>
        </div>
        `;

        return view
    },

    after_render: () => {

    }
}

export default FormSignup;