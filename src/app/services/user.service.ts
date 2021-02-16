import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from 'src/config';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/internal/observable/of';

import { ILogin, IRegister, ISession } from '../shared/interfaces/user.interface';

//falta inserir os modais para caso de erros, etc
@Injectable()
export class UserService extends Config {

    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(private http: HttpClient) {
        super();
    }

    public doLogin(data: ILogin) {
        this.http.post<ISession>(`${this.baseURL}login`, data, this.httpOptions)
          .subscribe(data => this.setDataIntoLocalStorage(data));
    }

    public register(data: IRegister) {
        this.http.post(`${this.baseURL}nova-senha`, data, this.httpOptions)
          .subscribe(data => data);
    }

    public createNewPassword(login: string) {
        const data = { login: login, email: "not-implemented@desbugados.com" }

        this.http.post(`${this.baseURL}usuarios`, data, this.httpOptions)
          .pipe(catchError(this.handleError('register', 'Erro ao realizar cadastro de nova senha')))
          .subscribe(data => data);
    }

    public updatePassword(senha: string) {
        const login = JSON.parse(localStorage.getItem('login')!);
        const token = JSON.parse(localStorage.getItem('token')!);
        this.httpOptions.headers.set('Authorization', token);

        const data = { senha: senha, usuario: login }

        this.http.post(`${this.baseURL}altera-senha`, data, this.httpOptions)
          .subscribe(data => data);
    }

    private handleError<T> (operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

          console.error(error);

          return of(result as T);
        };
    }

    private setDataIntoLocalStorage (data: ISession) {
        let { token, login, dataInicio, dataFim } = data;

        localStorage.setItem('dataInicio', JSON.stringify(dataInicio));
        localStorage.setItem('dataFim', JSON.stringify(dataFim));
        localStorage.setItem('token', JSON.stringify(token));
        localStorage.setItem('login', JSON.stringify(login));
    }
}