import { Component, OnInit } from '@angular/core';
import { DashboardService } from 'src/app/services/dashboard.service';
import { ILancamento } from './dashboard.interface';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})

export class DashboardComponent implements OnInit {

  constructor() { }

  public accounts = {
    CORRENTE: {
        type: 'Conta Corrente',
        icon: '../../../../assets/img/svg/dollar.svg',
        colorValue: 'green',
        saldo: 0,
        lancamentos: <ILancamento[]>[]
    },

    POUPANCA: {
        type: 'Conta Poupanca',
        icon: '../../../../assets/img/svg/dollar.svg',
        colorValue: 'blue',
        saldo: 0,
        lancamentos: <ILancamento[]>[]
    },

    CREDITO: {
        type: 'Conta de Crédito',
        icon: '../../../../assets/img/svg/card.svg',
        colorValue: 'red',
        saldo: 0,
        lancamentos: <ILancamento[]>[]
    }
  }

  public message: string = 'Olá, Usuár, seja bem vind! :)'

  ngOnInit(): void {
      let objTest: ILancamento = {
        date: new Date(),
        descricao: 'Descrição teste',
        valor: 26
      }
      this.accounts.CORRENTE.lancamentos.push(objTest);
  }
}
