import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { take, finalize } from 'rxjs/operators';
import { ChangePassService } from './changepass.service';

//testar implementação, se formos utilizá-la
@Component({
  selector: 'app-changepass',
  templateUrl: './changepass.component.html'
})
export class ChangepassComponent implements OnInit {
  @ViewChild('senhaInput') senhaInput:ElementRef|undefined
  @ViewChild('novaSenhaInput') novaSenhaInput:ElementRef|undefined

  senha = ""
  msgError=""

  loading:boolean = false

  constructor(
    private service: ChangePassService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    if(!form.valid){
      form.controls['senhaantiga'].markAsTouched;
      form.controls['senhanova'].markAsTouched;

      if(!form.controls.novasenha.valid){
        this.senhaInput?.nativeElement.focus()
        return;
      }
      if(!form.controls.senha.valid){
        this.novaSenhaInput?.nativeElement.focus()
        return;
      }
    }

    this.changePassword()
  }

  changePassword(){
    this.loading = true
    this.service.updatePassword(this.senha)
      .pipe(
        take(1),
        finalize(() => this.loading = false)
      )
      .subscribe(
        response => alert ('Atualização realizada com sucesso!'),
        error => this.onError(error)
      )
  }

  private onError(error:HttpErrorResponse){
    this.loading = false
    this.msgError = error.error
  }
}
