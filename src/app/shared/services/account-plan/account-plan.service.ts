import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { IAccountPlan } from '../../interfaces/account-plan.interface';

@Injectable({
  providedIn: 'root'
})
export class AccountPlanService {

  API_URL = environment.API_URL
  httpOptions = {};

  constructor(
    private http:HttpClient,
    private authService: AuthService
  ) {
    this.httpOptions =  {
      headers: new HttpHeaders(
        {
          'Content-Type': 'application/json',
          'Authorization': this.authService.getToken()
        }
      ),
    };
  }

  public createAccountPlan(finalidade: string){
    const data = { finalidade: finalidade, login: this.authService.getLogin() }

    return this.http.post<string>(`${this.API_URL}lancamentos/planos-conta`, data, this.httpOptions)
  }

  public getAccountPlans(): Observable<IAccountPlan[]>{
    const params = new HttpParams()
      .set('login', this.authService.getLogin());

      return this.http.get<IAccountPlan[]>(`${this.API_URL}lancamentos/planos-conta/?${params}`, this.httpOptions)
  }
}
