import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { take } from 'rxjs/operators';
import { ILoginCredencials, ILoginResponse } from './login.interface';

import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  usuario = ""
  senha = ""

  constructor(
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    this.doLogin()
  }

  //capturar dados para realizar login
  doLogin(){
    const credencials:ILoginCredencials = {usuario:this.usuario, senha:this.senha,}
    this.loginService.doLogin(credencials)
      .pipe(
        take(1)
      )
      .subscribe(
        response => this.onSuccess(response),
        error => this.onError(error)
        
      )
  }

  private onSuccess(response:ILoginResponse){
    console.log(response);
    
  }
  private onError(error:HttpErrorResponse){
    console.log(error);
    
  }
}
