import { Component, OnInit } from '@angular/core';
import { ITransaction } from 'src/app/shared/interfaces/dashboard.interface';

import { TransactionService } from './transaction.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent {

  constructor(private service: TransactionService) { }

  public message: string = 'Olá, Usuár, seja bem vind! :)'
  public transferencia: boolean = false
  public selected: string = ''

  isTranfer(){
    (this.selected === "TRANSFERENCIA") ? this.transferencia = true : this.transferencia = false;
  }

  doTransaction(){
    const transaction: ITransaction = {
        contaDestino: {
          login: 'emersonteste',
          sigla: 'POUPANCA'
        },
        contaOrigem: {
          login: 'emersonteste',
          sigla: 'POUPANCA'
        },
        date: new Date(),
        descricao: 'TESTE DE DESCRIÇÃO',
        planoConta: 'PAGAMENTO',
        valor: 252
    }

    const operacao = 'DEPOSITO';

    this.service.doTransaction(transaction, operacao).subscribe();
  }

}
