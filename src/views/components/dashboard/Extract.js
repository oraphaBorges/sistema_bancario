import DashboardService from '../../../service/DashboardService';
import { dashboardHeader as Header } from '../index';

const Extract = {
    render:  () => {
        const NOME_USUARIO = 'nome usuario';
        let view = `
            <div class="dash-header">
                <div class="section">
                    ${ Header.render(`Olá, <strong id="user-name">${NOME_USUARIO}</strong>, seja bem-vind!`, ) }
                </div>
            </div>
            <div class="content-default">
                ${extract}
            </div>
        `;

        return view
    },

    after_render: () => {
        Header.after_render();
        Extract.bindEvents();
    },

    bindEvents: async () => {
        const form_period = document.getElementById('form_period');

        form_period.addEventListener('submit', async (e) => {
            e.preventDefault();
  
            let data = {};
  
            for(let i = 0; i < form_period.elements.length; i++){
                  const element = form_period.elements[i]; 
                  if(element.value !== ''){
                      data[element.id] = element.value;
                  }
            }
                       
            const transactionsData = await DashboardService.getStatementByPeriod(data);
            Extract.updateTransactionsList(transactionsData, data.sigla);

        });
    },

    updateTransactionsList: ({ saldo, lancamentos }, sigla) => {
        const transaction_list = document.getElementById('transaction_list');
        let html =  [];

        html.push(getSaldoDiv(saldo, sigla));

        lancamentos.forEach(lancamento => {
            const { date, descricao, planoConta, valor, contaDestino, contaOrigem } = lancamento;
            let newDiv = getLancamentoDiv(date, descricao, planoConta, valor, contaDestino, contaOrigem);

            html.push(newDiv);
        })

        transaction_list.innerHTML = html.join('');
    }
}

export default Extract;

//You can do whatever you want aqui :)
let getSaldoDiv = (saldo, conta) => `
    <div>
        Conta selecionada: ${conta}
    </div>
    <div>
        Saldo: ${ saldo }
    </div>
`

//as contaDestino e contaOrigem tem o .login e .sigla, caso queira utilizar
let getLancamentoDiv = (date, descricao, planoConta, valor, contaDestino, contaOrigem) => `
<li>
    Data: ${date}
    Descrição: ${descricao}
    Plano de conta: ${planoConta}
    Valor: ${valor}
</li>
`

let extract = `
    <div class="card">
        <form id="form_period">
            <div style="flex-wrap: wrap" class="content-flex">
                <div class="content-flex mr-2">
                    <label class="mr-1">Início</label>
                    <input type="date" id="dataInicio">
                </div>
                <div class="content-flex">
                    <label class="mr-1">Até</label>
                    <input type="date" id="dataFim">
                </div>
            </div>
            <div class="content-justify content-flex--column m-1 content-flex--1">
                <label for="sigla" class="text-center">Escolha uma conta</label>
                <select name="sigla" class="align-last--center" id="sigla" required>
                    <option value="POUPANCA">Conta Poupança</option>
                    <option value="CORRENTE">Conta Corrente</option>
                    <option value="CREDITO">Conta de Crédito</option>
                </select>
            </div>
            <button type="submit" class="btn btn-rounded btn-main-outline mt-2 mx-auto">Filtrar extrato</button>
        <form>
    </div>
    <div style="width: 100%; box-sizing: border-box;" class="card mt-2" id="transaction_list">
        <div>
            <div class="bg-light p-1 text-left">
                <h5>11 de Fevereiro</h5>
            </div>
            <div  class="bloco p-1">
                <div>Int pag banco</div>
                <div> - R$ 249,97</div>
            </div>
            <div class="bloco p-1 bg-light">
                <div>Int pag banco</div>
                <div> - R$ 249,97</div>
            </div>
            <div class="bloco p-1">
                <div>Int pag banco</div>
                <div> - R$ 249,97</div>
            </div>        
        </div>
        <div class="mt-2">
            <div class="bg-light p-1 text-left">
                <h5>09 de Fevereiro</h5>
            </div>
            <div  class="bloco p-1">
                <div>Int pag banco</div>
                <div> - R$ 249,97</div>
            </div>
            <div class="bloco p-1 bg-light">
                <div>Int pag banco</div>
                <div> - R$ 249,97</div>
            </div>
            <div class="bloco p-1">
                <div>Int pag banco</div>
                <div> - R$ 249,97</div>
            </div>        
        </div>
    </div>
`