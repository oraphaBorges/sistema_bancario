import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { environment } from 'src/environments/environment';

//implementar rota privada para conseguir utilizar o serviço
@Injectable({
  providedIn: 'root'
})
export class ChangePassService {

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

  public updatePassword(senha: string) {
    const data = { senha: senha, usuario: this.authService.getLogin() }

    return this.http.post(`${this.API_URL}altera-senha`, data, this.httpOptions)
  }
}
