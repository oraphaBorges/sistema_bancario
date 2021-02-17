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

  message: string = ''
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
    
      const data = new Date(Date.now()).toISOString().slice(0,10)  
      if(!dataInicio)
        dataInicio = data.slice(0,8)+'01'
      if(!dataFim)
        dataFim = data

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
  txtValor(valor:number ){
    return {
      'text-positivo':valor>0,
      'text-negativo':valor<0,
      'text-neutro':valor==0,
    }
  }
}
