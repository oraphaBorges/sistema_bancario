import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ISession } from '../shared/interfaces/session.interface';
import { AuthService } from '../shared/services/auth/auth.service';
import { ILoginCredencials, ILoginResponse } from './login.interface';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  API_URL = environment.API_URL

  constructor(
    private http:HttpClient,
    private authService: AuthService
  ) { }

  doLogin(credencials:ILoginCredencials):Observable<ISession>{
    return this.http.post<ISession>(`${this.API_URL}login`,credencials)
      .pipe(
        tap(response=>{this.authService.setSession(response)    
        })
      )
  }
}
