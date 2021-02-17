import { Component } from '@angular/core';
import { TransactionService } from './transaction.service';

import { IAccountPlan } from 'src/app/shared/interfaces/account-plan.interface';
import { ITransaction } from './transaction.interface';
import { AccountPlanService } from 'src/app/shared/services/account-plan/account-plan.service';
import { finalize, take } from 'rxjs/operators';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent {

  constructor(private service: TransactionService, private accountPlanService: AccountPlanService) { }

  account_plans: IAccountPlan[] = [];

  public loading:boolean = false;
  public message: string = 'Olá, Usuár, seja bem vind! :)'
  public transferencia: boolean = false
  public operacao: string = '';

  ngOnInit(){
    this.getAccountPlans();
  }

  isTranfer(){
    (this.operacao === "TRANSFERENCIA") ? this.transferencia = true : this.transferencia = false;
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

  getAccountPlans(){
      this.loading = true;
      this.accountPlanService.getAccountPlans()
      .pipe(
        take(1),
        finalize(() => this.loading = false)
      ).subscribe(
        response => this.account_plans = response,
        error => alert(`Erro ao carregar planos de conta: ${error}`, )
      )
  }

}
