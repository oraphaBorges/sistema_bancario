import { dashboardHeader as Header } from '../index';
import dollarIcon from '../../../assets/img/svg/dollar.svg'
import cardIcon from '../../../assets/img/svg/card.svg'
import cardOpenedIcon from '../../../assets/img/svg/opencard.svg'

const Main = {
    render: () => {
        let view = `
        <div class="content-default">
            <div class="content-default content-flex content-justify">
                <div class="section">
                ${ Header.render('Olá, <strong>Pessoa lendo</strong>, seja bem-vin!') }
                </div>
            </div>
            <div class="content-default content-flex content-justify">
                <div class="section content-flex">
                ${section1}
                </div>
            </div>
            <div class="content-default content-flex content-justify">
                <div class="section">
                ${section2}
                </div>
            </div>
        </div>
        `;

        return view
    },

    after_render: () => { 
        console.log('teste')
    },
}

export default Main;

let section1 = `
    <div class="card-dashboard--default m-1 flex-wrap--40">
        <div class="content-intern--default content-flex content-align--center">
            <img src="${ dollarIcon }"  class="content-icon--default" alt="">
            <span class="text-card--default">Conta</span>
        </div>
        <div class="content-intern--default">
            <span class="text-card--default">Saldo disponível</span>
            <h2 class="text-money">R$: 2.354,00</h2>
        </div>
        <div class="content-intern--default content-flex content-align--center">
            <span class="text-card--default content-flex--1">Transações</span>
            <h2 class="text-money text-color--green">R$: 2.354,00</h2>
        </div>
    </div>
    <div class="card-dashboard--default m-1 flex-wrap--40">
        <div class="content-intern--default content-flex content-align--center">
            <img src="${ cardIcon }"  class="content-icon--default" alt="">
            <span class="text-card--default">Conta crédito</span>
        </div>
        <div class="content-intern--default">
            <span class="text-card--default">Fatura atual</span>
            <h2 class="text-money text-color--blue">R$: 522,12</h2>
        </div>
        <div class="content-intern--default content-flex content-align--center">
            <span class="text-card--default content-flex--1">Limite disponível</span>
            <h2 class="text-money text-color--green">R$: 9.120,88</h2>
        </div>
    </div>
`
let latestTransactions = `
    <div class="content-intern--default content-flex" id="transaction">
        <img src="${ cardOpenedIcon }" class="content-icon--default" alt="">
        <div class="content-transaction content-flex--1 content-flex--column">
            <div class="payment-description content-flex content-flex--1 content-justify--between content-align--center">
                <span class="text-color--black"><strong>Compra no débito</strong></span>
                <span class="text-color--grey text-size--12">24 de jan.</span>
            </div>
            <span class="text-card--default content-padding--default">Gama Academy</span>
            <span class="text-color--black text-weight--bold text-size--20">R$ 178,10</span>
        </div>
    </div>
`
let section2 = `
    <div class="card-dashboard--default m-1">
        <div class="content-intern--default content-flex content-align--center">
            <img src="${ dollarIcon }" class="content-icon--default" alt="">
            <span class="text-card--default">Últimos lançamentos</span>
            <a id="see_more" class="text-card--ancor">Ver extrato completo</a>
        </div>
        ${ latestTransactions }
    </div>
`

