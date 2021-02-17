import { Component, OnInit } from '@angular/core';
import { finalize, take } from 'rxjs/operators';
import { ILancamento } from 'src/app/shared/interfaces/dashboard.interface';
import { IResponseStatement } from './extrato.interface';
import { ExtratoService } from './extrato.service';

@Component({
  selector: 'app-extrato',
  templateUrl: './extrato.component.html'
})
export class ExtratoComponent implements OnInit {

  constructor(private service: ExtratoService) { }

  loading: boolean = false;
  accountData: IResponseStatement = { lancamentos: [], saldo: -1 };

  ngOnInit(): void {
    // this.getStatementByAccount();
    this.getStatementByPeriod();
  }

  getStatementByAccount(){
    this.loading = true;
    this.service.getStatementByAccount('CORRENTE').
    pipe(
      take(1),
      finalize(() => this.loading = false)
    )
    .subscribe(
      response => this.accountData = response,
      error => console.error(error)
    )
  }

  getStatementByPeriod(){
    this.loading = true;
    this.service.getStatementByPeriod({dataFim: new Date(), dataInicio: new Date(), sigla: 'CORRENTE'}).
    pipe(
      take(1),
      finalize(() => this.loading = false)
    )
    .subscribe(
      response => this.accountData = response,
      error => console.error(error)
    )
  }
}
