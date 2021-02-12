import { dashboardHeader as Header, card as Card} from '../index';

const Main = {
    render: () => {
        let view = `
        <div class="content-default">
            ${ Header.render('Olá, <strong>Nome</strong>') }
            <div class="section content-default content-flex">
                ${section1}
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
    <div class="card-dashboard--default m-1 flex-wrap">
        <div class="content-intern--default content-flex align-items--center">
            <img src="./assets/img/svg/dollar.svg"  class="content-icon--default padding-right--15" alt="">
            <span class="text-card--default">Conta</span>
        </div>
        <div class="content-intern--default">
            <span class="text-card--default">Saldo disponível</span>
            <h2 class="text-money margin-top--8">R$: 2.354,00</h2>
        </div>
        <div class="content-intern--default content-flex align-items--center">
            <span class="text-card--default content-flex--1">Transações</span>
            <h2 class="text-money text-color--green">R$: 2.354,00</h2>
        </div>
    </div>
    <div class="card-dashboard--default m-1 flex-wrap">
        <div class="content-intern--default content-flex align-items--center">
            <img src="./assets/img/svg/card.svg"  class="content-icon--default padding-right--15" alt="">
            <span class="text-card--default">Conta crédito</span>
        </div>
        <div class="content-intern--default">
            <span class="text-card--default">Fatura atual</span>
            <h2 class="text-money margin-top--8 text-color--blue">R$: 522,12</h2>
        </div>
        <div class="content-intern--default content-flex align-items--center">
            <span class="text-card--default content-flex--1">Limite disponível</span>
            <h2 class="text-money text-color--green">R$: 9.120,88</h2>
        </div>
    </div>
`

