import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Config } from 'src/config';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/internal/observable/of';

import { IRegister } from '../shared/interfaces/user.interface';

//falta inserir os modais para caso de erros, etc
@Injectable()
export class UserService extends Config {

    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(private http: HttpClient) {
        super();
    }

    public register(data: IRegister) {
        this.http.post(`${this.baseURL}nova-senha`, data, this.httpOptions)
    }

    public createNewPassword(login: string) {
        const data = { login: login, email: "not-implemented@desbugados.com" }

        this.http.post(`${this.baseURL}usuarios`, data, this.httpOptions)
          .pipe(catchError(this.handleError('register', 'Erro ao realizar cadastro de nova senha')))
    }

    public updatePassword(senha: string) {
        const login = JSON.parse(localStorage.getItem('login')!);
        const token = JSON.parse(localStorage.getItem('token')!);
        this.httpOptions.headers.set('Authorization', token);

        const data = { senha: senha, usuario: login }

        this.http.post(`${this.baseURL}altera-senha`, data, this.httpOptions)
    }

    private handleError<T> (operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

          console.error(error);

          return of(result as T);
        };
    }
}
