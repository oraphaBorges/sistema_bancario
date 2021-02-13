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
            <div class="accounts content-default content-flex content-justify">
                ${ accountCard }
                ${ accountCard }
                ${ accountCard }
            </div>
        </div>
        `;

        return view
    },

    after_render: () => { 
        
    },
}

export default Main;

let accountCard = `
    <div class="card-dashboard--default m-1">
        <div class="content-intern--default content-flex content-align--center">
            <img src="${ cardIcon }"  class="content-icon--default" alt="">
            <span class="text-card--default">Conta crédito</span>
        </div>
        <div class="content-intern--default content-flex content-justify--between">
            <div class="content-intern--default">
                <span class="text-card--default">Fatura atual</span>
                <h2 class="text-money text-color--blue">R$: 522,12</h2>
            </div>
            <div class="content-intern--default">
                <span class="text-card--default">Limite disponível</span>
                <h2 class="text-money text-color--green">R$: 9.120,88</h2>
            </div>
        </div>
        <div id="latest_transactions">
            <div class="content-intern--default content-flex content-justify--between">
                <span class="text-card--default">Últimos lançamentos</span>
                <a id="see_more" class="text-card--ancor">Ver extrato completo</a>
            </div>
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
        </div>
    </div>
`
