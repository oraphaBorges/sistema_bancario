import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs/internal/observable/of';

import { Config } from 'src/config';

@Injectable()
export class DashboardService extends Config {

    httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(private http: HttpClient) {
        super();
     }

    //remover função no futuro, somente exemplo
    public test() {
      const response = this.http.post(`${this.baseURL}login`, { usuario: 'emersonteste', senha: 'emersonteste' }, this.httpOptions)
        .pipe(catchError(this.handleError('doLogin', 'Erro ao realizar Login')))
        .subscribe(data => data);
    }

    private handleError<T> (operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {

        console.error(error);

        return of(result as T);
      };
    }
}
