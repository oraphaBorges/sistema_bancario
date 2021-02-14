import transactionIcon from '../../../assets/img/svg/transaction.svg';

import { dashboardHeader as Header, loader as Loader } from '../index';
import DashboardService from '../../../service/DashboardService';

const Transaction = {
  
    render: () => {
        const PLANOS_CONTA = JSON.parse(localStorage.getItem('PLANOS_CONTA'));  
        const plans = PLANOS_CONTA.map(plan => `<option value="${plan}">${plan}</option>`).join('');

        let view = `
        <div class="content-default">
            <div class="content-default content-flex content-justify">
                <div class="section">
                ${ Header.render('Olá, <strong>Pessoa lendo</strong>, seja bem-vin!') }
                </div>
            </div>
            <div class="content-default content-flex content-justify">
                ${ transaction(plans) } 
            </div>
        </div>
        `;

        return view
    },

    after_render: () => {
        Transaction.bindEvents();
    },

    bindEvents: () => {
        const transferDiv = document.getElementById('transfer_div');

        //Manipulando conteúdo exibido somente para transferências
        const operacao = document.getElementById('operacao');
        operacao.addEventListener('click', e => {
            const valueSelected = e.target.value;
            if(valueSelected === 'TRANSFERENCIA'){
                transferDiv.innerHTML = transfer_div;
            } else {
                transferDiv.innerHTML = '';
            }
        })

        const transaction_form = document.getElementById('transaction_form');
        transaction_form.addEventListener('submit', async e => {
            e.preventDefault();
            let data = {};

            for(let i = 0; i < transaction_form.elements.length; i++){
                  const element = transaction_form.elements[i]; 
                  data[element.id] = element.value;
            }

            transaction_form.innerHTML = Loader;
            const result = await DashboardService.setTransaction(data);

            if(result){
                setTimeout(() => {
                    transaction_form.innerHTML = `
                        <p class="text-center">hm... parece que tudo deu certo :)</p>
                        <p class="text-center">
                            <a id="do-reload">Clique em Home</a> para voltar ao dashboard 
                        </p>
                    ` 
                }, 1500)
            } else {
                transaction_form.innerHTML = `
                    <p class="text-center">hm... algo deu errado :(</p>
                    <p class="text-center">
                        <a id="do-reload">Clique em Home</a> para voltar ao dashboard e tentar novamente mais tarde
                    </p>
                `
            }
        }) 
    },
}

let transfer_div = `
    <div class="content-justify content-flex--column m-1 content-flex--1">
        <label for="destino_sigla" class="text-center">Conta de destino</label>
        <select name="destino_sigla" class="align-last--center" id="destino_sigla" required>
            <option value="POUPANCA">Conta Poupança</option>
            <option value="CORRENTE">Conta Corrente</option>
            <option value="CREDITO">Conta de Crédito</option>
        </select>
    </div>
    <div class="content-justify content-flex--column m-1 content-flex--1">
        <label for="destino_login" class="text-center">Login de destino</label>
        <input type="text" id="destino_login" placeholder="Ex: emerson" required/>
    </div>
`

let transaction = (plans) => `
    <div class="transaction flex-wrap--30 card-dashboard--default section m-1">
        <form id="transaction_form">
            <div class="p-1 content-flex content-justify">
                <img src="${ transactionIcon }" class="content-icon--big" alt="">
            </div>
            <div class="p-1 content-flex content-justify">
                <h2 class="text-purple">Realizar transação</h2>
            </div>
            <div class="p-1 content-flex--column content-justify">
                <label for="operacao" class="text-center">Escolha um tipo de transação:</label>
                <select name="operacao" class="align-last--center" id="operacao" required>
                    <option value="DEPOSITO">Depósito</option>
                    <option value="PAGAMENTO">Pagamento</option>
                    <option value="TRANSFERENCIA">Transferência</option>
                </select>
            </div>
            <div class="p-1 content-flex--column content-justify">
                <label for="origem_sigla" class="text-center">Qual é a sua conta?</label>
                <select name="origem_sigla" class="align-last--center" id="origem_sigla" required>
                    <option value="POUPANCA">Conta Poupança</option>
                    <option value="CORRENTE">Conta Corrente</option>
                    <option value="CREDITO">Conta de Crédito</option>
                </select>
            </div>
            <div class="transfer-div content-justify--between content-flex" id="transfer_div">
            </div>
            <div class="p-1 content-flex--column content-justify">
                <label for="descricao" class="text-center">Descrição</label>
                <input type="text" id="descricao" placeholder="Ex: mercado" required/>
            </div>
            <div class="p-1 content-flex--column content-justify">
                <label for="planoConta" class="text-center">Plano de conta</label>
                <select name="planoConta" class="align-last--center" id="planoConta" required>
                    ${ plans }
                </select>
            </div>
            <div class="p-1 content-flex--column content-justify">
                <label for="valor" class="text-center">Valor</label>
                <input id="valor" type="number" placeholder="ex: 250.00" required/>
            </div>
            <div class="p-1 content-flex--column content-justify">
                <button id="button_submit" >Enviar</button>
            </div>
        </form>
    </div>
`

export default Transaction;