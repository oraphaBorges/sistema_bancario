import { dashboardHeader as Header, card as Card} from '../index';

const Transaction = {
  
    render:  () => {
        let view = `
            ${Header.render('Olá, <strong>Pessoa lendo</strong>, seja bem-vindo!') }
            <div style="flex-wrap: wrap" class="container-width--full content content-default content-flex content-justify content-justify--between">
                ${payment} 
                ${deposit}
                ${transfer}   
            </div> 
        `;

        return view
    }
}

let payment = `
    <div class="card">
        <h2 class="text-purple">Pagamento</h2>
        <div class="account-transfer cards-transactions">
            <div class="m-1">
                <select class="container-width--full" id="select-account">
                <option selected disabled>Escolha uma conta</option>
                <option value="conta">Conta</option>
                <option value="credito">Conta crédito</option>
                </select>
            </div>
            <div>
                <div class="m-1">
                    <label class="mr-1" for="">Plano de conta</label>
                    <select name="" id="">
                        <option value="">Crédito</option>
                        <option value="">Débito</option>
                    </select>
                </div>
                <div class="m-1 bloco">
                    <label class="mr-1" for="">Conta</label>
                    <input type="text" />
                </div>
                <div class="m-1 bloco">
                    <label for="">Valor</label>
                    <input type="text" placeholder="R$" />
                </div>
            </div>
            <button class="btn btn-rounded btn-main-outline m-1">Realize o pagamento</button>
        </div>          
    </div> 
`
let deposit = `
    <div class="card">
        <h2 class="text-purple">Depósito</h2>
        <div class="account-transfer cards-transactions">
            <div class="m-1">
                <select class="container-width--full" id="select-account">
                <option selected disabled>Escolha uma conta</option>
                <option value="conta">Conta</option>
                <option value="credito">Conta crédito</option>
                </select>
            </div>
            <div>
                <div class="m-1">
                    <label class="mr-1" for="">Plano de conta</label>
                    <select name="" id="">
                        <option value="">Crédito</option>
                        <option value="">Débito</option>
                    </select>
                </div>
                <div class="m-1 bloco">
                    <label class="mr-1" for="">Conta</label>
                    <input type="text" />
                </div>
                <div class="m-1 bloco">
                    <label for="">Valor</label>
                    <input type="text" placeholder="R$" />
                </div>
            </div>
            <button class="btn btn-rounded btn-main-outline m-1">Realize o depósito</button>
        </div>          
    </div> 
`
let transfer = `
    <div class="card">
        <h2 class="text-purple">Transação</h2>
        <div class="account-transfer cards-transactions">
            <div class="m-1">
                <select class="container-width--full" id="select-account">
                <option selected disabled>Escolha uma conta</option>
                <option value="conta">Conta</option>
                <option value="credito">Conta crédito</option>
                </select>
            </div>
            <div>
                <div class="m-1">
                    <label class="mr-1" for="">Plano de conta</label>
                    <select name="" id="">
                        <option value="">Crédito</option>
                        <option value="">Débito</option>
                    </select>
                </div>
                <div class="m-1 bloco">
                    <label class="mr-1" for="">Conta</label>
                    <input type="text" />
                </div>
                <div class="m-1 bloco">
                    <label for="">Valor</label>
                    <input type="text" placeholder="R$" />
                </div>
            </div>
            <button class="btn btn-rounded btn-main-outline m-1">Realize a transação</button>
        </div>          
    </div> 
`

export default Transaction;