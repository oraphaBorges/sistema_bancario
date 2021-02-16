import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from 'src/config';

import { Observable } from 'rxjs';
import { of } from 'rxjs/internal/observable/of';

import { IStatementByPeriod } from '../shared/interfaces/dashboard.interface';

@Injectable()
export class DashboardServiceOld extends Config {
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

    public createAccountPlan(finalidade: string){
      const data = { finalidade: finalidade, login: this.login }

      this.http.post<any>(`${this.baseURL}/lancamentos/planos-conta`, data, this.httpOptions)
    }

    //setar retorno em local storage
    public getAccountPlans(){
      const params = new HttpParams()
        .set('login', this.login);

        this.http.post<any>(`${this.baseURL}/lancamentos/planos-conta/`, this.httpOptions)
    }

    public getStatementByAccount(sigla: string){
      const params = new HttpParams()
        .set('login', this.login)
        .set('sigla', sigla);


      this.http.post<any>(`${this.baseURL}/conta/extrato`, this.httpOptions)
    }

    public getStatementByPeriod(data: IStatementByPeriod){
      const params = new HttpParams()
        .set('login', this.login)
        .set('dataInicio', JSON.stringify(data.dataInicio))
        .set('dataFim', JSON.stringify(data.dataFim))
        .set('sigla', data.sigla)

      this.http.post<any>(`${this.baseURL}/conta/extrato-periodo`, this.httpOptions)
    }

    //implementar essa
    private handleError<T> (operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

          console.error(error);

          return of(result as T);
        };
    }
}
