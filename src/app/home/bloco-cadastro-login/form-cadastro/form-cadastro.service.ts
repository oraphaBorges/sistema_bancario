import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ISignup } from '../../../shared/interfaces/signup.interface';
import { AuthService } from '../../../shared/services/auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class FormCadastroService {
  API_URL = environment.API_URL

  constructor(
    private http:HttpClient,
    private authService: AuthService
  ) { }

  doSignup(credencials:ISignup):Observable<any>{
    return this.http.post<any>(`${this.API_URL}usuarios`,credencials)
      .pipe(
        tap(response=>{this.authService.setSession(response)  
        })
      )
  }
}
