import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { finalize, take } from 'rxjs/operators';
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

  msgError=""

  loading:boolean = false
  errorLoging:boolean = false

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
    this.errorLoging = false
    this.loading = true
    const credencials:ILoginCredencials = {usuario:this.usuario, senha:this.senha,}
    this.loginService.doLogin(credencials)
      .pipe(
        take(1),
        finalize(()=>this.loading=false)
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
    this.errorLoging = true
    this.loading = false
    this.msgError = error.error
    
  }
}
