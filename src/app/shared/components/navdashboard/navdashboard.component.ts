import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navdashboard',
  templateUrl: './navdashboard.component.html',
 })
export class NavDashboardComponent implements OnInit {

    logoUrl = '../../../../assets/img/svg/gamahand.svg'
    iconHome ='../../../../assets/img/svg/home.svg';
    iconTransactions ='../../../../assets/img/svg/transactions.svg';
    iconBankstatement = '../../../../assets/img/svg/bankstatement.svg';
    iconAccountPlan = '../../../../assets/img/svg/accountplan.svg';

    transcation = 'transaction'
    extract = 'extract'
    accountplan = 'accountplan'
    main = 'main'

    //inserir icone
    menuOptions = [
        { id: 'main', group: 'Home', icon: this.iconHome, route:this.main }, 
        { id: 'transactions', group: 'Transações', icon: this.iconTransactions, route: 'transaction' }, 
        { id: 'bankstatement', group: 'Extrato', icon: this.iconBankstatement , route: this.extract}, 
        { id: 'accountplan', group: 'Planos de Conta', icon: this.iconAccountPlan, route:this.accountplan}
    ]  

   

    constructor() { }

    ngOnInit(): void {
      
    }

}
