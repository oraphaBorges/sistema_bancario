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

  message: string = 'Olá, User, seja bem vind! :)'
  loading: boolean = false;
  accountData: IResponseStatement = { lancamentos: [], saldo: -1 };

  //form
  sigla: string = 'POUPANCA';
  dataInicio: string = '';
  dataFim: string = '';

  ngOnInit(): void {
    this.getStatementByAccount('POUPANCA');
  }

  filter(){
    this.getStatementByPeriod(this.sigla,this.dataInicio, this.dataFim)
  }

  getStatementByAccount(sigla: string){
    this.loading = true;
    this.service.getStatementByAccount(sigla).
    pipe(
      take(1),
      finalize(() => this.loading = false)
    )
    .subscribe(
      response => this.accountData = response,
      error => console.error(error)
    )
  }

  getStatementByPeriod(sigla: string, dataInicio: string, dataFim: string){
    this.loading = true;
    if(!dataInicio)
      dataInicio = '2020-12-20';
    if(!dataFim)
      dataFim = '2030-12-30';

    this.service.getStatementByPeriod({ dataFim, dataInicio, sigla }).
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
