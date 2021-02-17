import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAccountResponse } from 'src/app/shared/interfaces/dashboard.interface';

import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  API_URL = environment.API_URL

  constructor(
    private http:HttpClient,
    private authService: AuthService
  ) { }


  public getAccountData(): Observable<IAccountResponse[]>{
    const dataInicio = '2020-01-30';
    const dataFim = '2030-01-30';

    const httpOptions = {
      headers: new HttpHeaders(
        {
          'Content-Type': 'application/json',
          'Authorization': this.authService.getToken()
        }
      ),
    };

    const params = new HttpParams()
      .set('inicio', dataInicio)
      .set('fim', dataFim)
      .set('login', this.authService.getLogin())

    return this.http.get<IAccountResponse[]>(`${this.API_URL}dashboard?${params}`, httpOptions)
  }
}
