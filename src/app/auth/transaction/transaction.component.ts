import { Component } from '@angular/core';
import { TransactionService } from './transaction.service';

import { ITransaction } from './transaction.interface';
import { AccountPlanService } from 'src/app/shared/services/account-plan/account-plan.service';
import { finalize, take, tap } from 'rxjs/operators';
import { NgForm } from '@angular/forms';
import { IAccountPlan } from 'src/app/shared/interfaces/dashboard.interface';

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

  //arrumar retorno p não dar erro e o formulário ser resetado no tap
  doTransaction(transaction: ITransaction, operacao: string, form: NgForm){
    this.loading = true;
    this.service.doTransaction(transaction, operacao).pipe(
      take(1),
      tap(() => form.resetForm()),
      finalize(() => this.loading = false)
    ).subscribe(
      error => alert(error)
    );
  }

  onSubmit(form: NgForm){
    if(form.invalid){
      alert('por favor, preencha todos os campos');

      return;
    }

    this.createObjTransaction(form);
  }

  private createObjTransaction(form: NgForm){
    const { operacao, descricao, origem_sigla, planoConta, valor } = form.value;

    let transaction: ITransaction = {
      contaDestino: {
        login: '',
        sigla: origem_sigla
      },
      contaOrigem: {
        login: '',
        sigla: origem_sigla
      },
      date: new Date(),
      descricao: descricao,
      planoConta: planoConta,
      valor: valor
    }

    if(operacao === 'TRANSFERENCIA'){
        const { destino_sigla, destino_login } = form.value;
        transaction.contaDestino.login = destino_login
        transaction.contaDestino.sigla = destino_sigla
    }

    this.doTransaction(transaction, operacao, form);
  }

  private getAccountPlans(){
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

  isTranfer(){
    (this.operacao === "TRANSFERENCIA") ? this.transferencia = true : this.transferencia = false;
  }
}
