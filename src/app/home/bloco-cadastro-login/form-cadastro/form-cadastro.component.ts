import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { take, finalize } from 'rxjs/operators';
import { ISignup } from 'src/app/shared/interfaces/signup.interface';
import { FormCadastroService } from './form-cadastro.service';

@Component({
  selector: 'app-form-cadastro',
  templateUrl: './form-cadastro.component.html',
  styleUrls: ['./form-cadastro.component.scss']
})
export class FormCadastroComponent implements OnInit {

  @ViewChild('cpfInput') cpfInput:ElementRef|undefined
  @ViewChild('nomeInput') nomeInput:ElementRef|undefined
  @ViewChild('loginInput') loginInput:ElementRef|undefined
  @ViewChild('senhaInput') SenhaInput:ElementRef|undefined
  @ViewChild('senhaConfirmadaInput') SenhaConfirmadaInput:ElementRef|undefined

  cpf = ""
  nome = ""
  login = ""
  senha = ""
  senha_confirmada = ""

  msgError=""

  loading:boolean = false
  errorLoging:boolean = false


  constructor(
    private cadastroService: FormCadastroService,
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    if(!form.valid){
      form.controls['cpf'].markAsTouched;
      form.controls['nome'].markAsTouched;
      form.controls['login'].markAsTouched;
      form.controls['senha'].markAsTouched;
      form.controls['senhaConfirmada'].markAsTouched;
      if(!form.controls.cpf.valid){
        this.cpfInput?.nativeElement.focus()
        return;
      }
      if(!form.controls.nome.valid){
        this.nomeInput?.nativeElement.focus()
        return;
      }
      if(!form.controls.login.valid){
        this.loginInput?.nativeElement.focus()
        return;
      }
      if(!form.controls.senha.valid){
        this.SenhaInput?.nativeElement.focus()
        return;
      }
      if(!form.controls.senhaConfirmada.valid){
        this.SenhaConfirmadaInput?.nativeElement.focus()
        return;
      }
    }  

    if(form.controls.senha.value != form.controls.senhaConfirmada.value){
      this.errorLoging=true
      this.msgError="Sua senha está diferente da senha confrimada"
      this.SenhaConfirmadaInput?.nativeElement.focus()
      return;
    }
    this.errorLoging=false
    this.msgError=""
    this.doSignup()
  }

  doSignup(){
    this.errorLoging = false
    this.loading = true
    const credencials:ISignup = {
      cpf: this.cpf.replace(/[^\d]+/g,'')	,
      login:this.login,
      nome:this.nome,
      senha:this.senha,
    }
    
    this.cadastroService.doSignup(credencials)
      .pipe(
        take(1),
        finalize(()=>this.loading=false)
      )
      .subscribe(
        response => this.onSuccess(response),
        error => this.onError(error)
        
      )
  }

  private onSuccess(response:any){
    this.router.navigate(['login'])    
  }
  private onError(error:HttpErrorResponse){
    if(error.status==201){
      this.onSuccess(error)
      return
    }
    this.errorLoging = true
    this.loading = false
    this.msgError = error.error
    
    
  }
}
