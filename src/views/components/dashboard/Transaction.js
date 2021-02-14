import { dashboardHeader as Header } from '../index';

import transactionIcon from '../../../assets/img/svg/transaction.svg';

const Transaction = {
  
    render: () => {
        let view = `
            ${Header.render('Olá, <strong>Pessoa lendo</strong>, seja bem-vindo!') }
            <div class="content content-default content-flex content-justify">
                ${ transaction } 
            </div> 
        `;

        return view
    },

    after_render: () => {
        const transferDiv = document.getElementById('transfer_div');
        const transaction_type = document.getElementById('transaction_type');
        transaction_type.addEventListener('click', e => {
            const valueSelected = e.target.value;
            if(valueSelected === 'TRANSFERENCIA'){
                transferDiv.innerHTML = transfer_div;
            } else {
                transferDiv.innerHTML = '';
            }
        })
    }
}

let transfer_div = `
    <div class="content-justify content-flex--column m-1">
        <label for="account_type" class="text-center">Conta de destino</label>
        <select name="account_type" class="align-last--center" id="account_type">
            <option value="POUPANCA">Conta Poupança</option>
            <option value="CORRENTE">Conta Corrente</option>
            <option value="CREDITO">Conta de Crédito</option>
        </select>
    </div>
    <div class="content-justify content-flex--column m-1">
        <label for="destiny_login" class="text-center">Login de destino</label>
        <input type="text" id="destiny_login" placeholder="Ex: emerson" />
    </div>
`

let transaction = `
    <div class="transaction flex-wrap--30 card-dashboard--default content-justify section m-1">
        <div class="p-1 content-flex content-justify">
            <img src="${ transactionIcon }" class="content-icon--big" alt="">
        </div>
        <div class="p-1 content-flex content-justify">
            <h2 class="text-purple">Realizar transação</h2>
        </div>
        <div class="p-1 content-flex--column content-justify">
            <label for="transaction_type" class="text-center">Escolha um tipo de transação:</label>
            <select name="transaction_type" class="align-last--center" id="transaction_type">
                <option value="DEPOSITO">Depósito</option>
                <option value="PAGAMENTO">Pagamento</option>
                <option value="TRANSFERENCIA">Transferência</option>
            </select>
        </div>
        <div class="p-1 content-flex--column content-justify">
            <label for="account_type" class="text-center">Qual é a sua conta?</label>
            <select name="account_type" class="align-last--center" id="account_type">
                <option value="POUPANCA">Conta Poupança</option>
                <option value="CORRENTE">Conta Corrente</option>
                <option value="CREDITO">Conta de Crédito</option>
            </select>
        </div>
        <div class="transfer-div content-justify--between content-flex" id="transfer_div">
        </div>
        <div class="p-1 content-flex--column content-justify">
            <label for="description" class="text-center">Descrição</label>
            <input type="text" id="description" placeholder="Ex: mercado" />
        </div>
        <div class="p-1 content-flex--column content-justify">
            <label for="account_type" class="text-center">Plano de conta</label>
            <select name="account_plan" class="align-last--center" id="account_plan">
                <option value="POUPANCA">Conta Poupança</option>
                <option value="CORRENTE">Conta Corrente</option>
            </select>
        </div>
        <div class="p-1 content-flex--column content-justify">
            <label for="transaction_description" class="text-center">Valor</label>
            <input id="transaction_description" type="number" placeholder="ex: 250.00"/>
        </div>
        <div class="p-1 content-flex--column content-justify">
            <button id="button_submit" >Enviar</button>
        </div>
    </div>
`

export default Transaction;