import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from 'src/config';

import { Observable } from 'rxjs';
import { of } from 'rxjs/internal/observable/of';

import { ITransaction, IStatementByPeriod } from '../shared/interfaces/dashboard.interface';

@Injectable()
export class DashboardService extends Config {
    private token = JSON.parse(localStorage.getItem('token')!);
    private login = JSON.parse(localStorage.getItem('login')!);

    httpOptions = {
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Authorization': this.token
          }
        ),
    };

    constructor(private http: HttpClient) {
        super();
    }

    //funcionando
    //inserir dados no local storage
    public getAccountData() {
        const dataInicio = '2020-01-30';
        const dataFim = '2030-01-30';

        const params = new HttpParams()
          .set('inicio', dataInicio)
          .set('fim', dataFim)
          .set('login', this.login)

        this.http.get(`${this.baseURL}dashboard?${params}`, this.httpOptions)
          .subscribe(data => data);
    }

    public doTransaction(data: ITransaction, operacao: string){
      const params = new HttpParams()
        .set('operacao', operacao)

      this.http.post<ITransaction>(`${this.baseURL}/lancamentos/`, data, this.httpOptions)
        .subscribe(data => data);
    }

    public createAccountPlan(finalidade: string){
      const data = { finalidade: finalidade, login: this.login }

      this.http.post<any>(`${this.baseURL}/lancamentos/planos-conta`, data, this.httpOptions)
        .subscribe(data => data);
    }

    //setar retorno em local storage
    public getAccountPlans(){
      const params = new HttpParams()
        .set('login', this.login);

        this.http.post<any>(`${this.baseURL}/lancamentos/planos-conta/`, this.httpOptions)
          .subscribe(data => data);
    }

    public getStatementByAccount(sigla: string){
      const params = new HttpParams()
        .set('login', this.login)
        .set('sigla', sigla);


      this.http.post<any>(`${this.baseURL}/conta/extrato`, this.httpOptions)
          .subscribe(data => data);
    }

    public getStatementByPeriod(data: IStatementByPeriod){
      const params = new HttpParams()
        .set('login', this.login)
        .set('dataInicio', JSON.stringify(data.dataInicio))
        .set('dataFim', JSON.stringify(data.dataFim))
        .set('sigla', data.sigla)

      this.http.post<any>(`${this.baseURL}/conta/extrato-periodo`, this.httpOptions)
          .subscribe(data => data);
    }

    //implementar essa
    private handleError<T> (operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

          console.error(error);

          return of(result as T);
        };
    }
}
