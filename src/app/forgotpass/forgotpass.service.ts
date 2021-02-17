import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { environment } from 'src/environments/environment';

//forbidden
@Injectable({
  providedIn: 'root'
})
export class ForgotPassService {

  API_URL = environment.API_URL
  httpOptions = {};


  constructor(
    private http:HttpClient
  ) {
    this.httpOptions = {
      headers: new HttpHeaders(
        {
          'Content-Type': 'application/json',
        }
      ),
    };
  }

  public sendEmail(login: string) {
    const data = { login: login, email: "not-implemented@desbugados.com" }

    return this.http.post(`${this.API_URL}nova-senha`, data, this.httpOptions)
  }
}
