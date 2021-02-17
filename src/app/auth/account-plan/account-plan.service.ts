import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { environment } from 'src/environments/environment';
import { IResponseAccountPlan } from './account-plan.interface';

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

    this.http.post<string>(`${this.API_URL}lancamentos/planos-conta`, data, this.httpOptions)
  }

  public getAccountPlans(): Observable<IResponseAccountPlan[]>{
    const params = new HttpParams()
      .set('login', this.authService.getLogin());

      return this.http.get<IResponseAccountPlan[]>(`${this.API_URL}lancamentos/planos-conta/?${params}`, this.httpOptions)
  }
}
