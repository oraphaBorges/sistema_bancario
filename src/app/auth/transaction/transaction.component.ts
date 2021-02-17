import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { finalize, take, tap } from 'rxjs/operators';

import { TransactionService } from './transaction.service';
import { AccountPlanService } from 'src/app/shared/services/account-plan/account-plan.service';

import { ITransaction } from './transaction.interface';
import { IAccountPlan } from 'src/app/shared/interfaces/dashboard.interface';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent {

  constructor(private service: TransactionService, private accountPlanService: AccountPlanService) { }

  account_plans: IAccountPlan[] = [];
  msgError = '';

  public loading:boolean = false;
  public message: string = 'Olá, Usuár, seja bem vind! :)'
  public transferencia: boolean = false
  public operacao: string = '';

  ngOnInit(){
    this.getAccountPlans();
  }

  doTransaction(transaction: ITransaction, operacao: string, form: NgForm){
    this.loading = true;
    this.service.doTransaction(transaction, operacao).pipe(
      take(1),
      tap(() => form.resetForm()),
      finalize(() => this.loading = false)
    ).subscribe(
      response => console.log(response),
      error => this.onError(error, 'Ocorreu um erro ao realizar a transação')
    );
  }

  onSubmit(form: NgForm){
    if(form.invalid){

      this.msgError = 'Por favor, preencha todos os campos';
      setTimeout(() => {
        this.msgError = '';
      }, 4000)

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
        error => this.onError(error, `Erro ao carregar planos de conta`, )
      )
  }

  isTranfer(){
    (this.operacao === "TRANSFERENCIA") ? this.transferencia = true : this.transferencia = false;
  }

  private onError(errorComplete: HttpErrorResponse, msg: string){
    let { error:{ error } } = errorComplete;
    this.loading = false
    this.msgError = msg + error;

    setTimeout(() => {
      this.msgError = '';
    }, 3000)
  }
}
