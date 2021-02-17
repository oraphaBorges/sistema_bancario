import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { environment } from 'src/environments/environment';

import { ITransaction } from './transaction.interface';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  API_URL = environment.API_URL

  constructor(
    private http:HttpClient,
    private authService: AuthService
  ) { }

  //incluir responseType para o erro no console não ocorrer
  public doTransaction(data: ITransaction, operacao: string): Observable<string>{
    data.contaOrigem.login = this.authService.getLogin();

    if(operacao !== 'TRANSFERENCIA')
      data.contaDestino.login = this.authService.getLogin();

    const params = new HttpParams()
      .set('operacao', operacao)

    const httpOptions = {
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'Authorization': this.authService.getToken()
          }
        ),
      };

    return this.http.post<string>(`${this.API_URL}lancamentos/?${params}`, data, httpOptions).pipe(
      tap(response => console.log(response), error => console.log(error))
    )
  }
}
