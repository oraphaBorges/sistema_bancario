import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { environment } from 'src/environments/environment';
import { IResponseStatement, IStatementByPeriod } from './extrato.interface';

@Injectable({
  providedIn: 'root'
})
export class ExtratoService {

  API_URL = environment.API_URL
  httpOptions = {};


  constructor(
    private http:HttpClient,
    private authService: AuthService
  ) {
    this.httpOptions = {
      headers: new HttpHeaders(
        {
          'Content-Type': 'application/json',
          'Authorization': this.authService.getToken()
        }
      ),
    };
  }
  public getStatementByAccount(sigla: string): Observable<IResponseStatement>{
    const params = new HttpParams()
      .set('login', this.authService.getLogin())
      .set('sigla', sigla);

    return this.http.get<IResponseStatement>(`${this.API_URL}conta/extrato?${params}`, this.httpOptions)
  }

  public getStatementByPeriod(data: IStatementByPeriod): Observable<IResponseStatement>{
    let dataInicioFormatted = data.dataInicio.toISOString().substring(0, 10);
    let dataFimFormatted = data.dataInicio.toISOString().substring(0, 10);

    const params = new HttpParams()
      .set('login', this.authService.getLogin())
      .set('dataInicio', dataInicioFormatted)
      .set('dataFim', dataFimFormatted)
      .set('sigla', data.sigla)

    return this.http.get<IResponseStatement>(`${this.API_URL}conta/extrato-periodo?${params}`, this.httpOptions)
  }
}
