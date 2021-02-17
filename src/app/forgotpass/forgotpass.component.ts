import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { finalize, take } from 'rxjs/operators';
import { ForgotPassService } from './forgotpass.service';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.scss']
})
export class ForgotpassComponent implements OnInit {
  @ViewChild('usuarioInput') usuarioInput:ElementRef|undefined

  usuario=""

  loading:boolean = false
  msgError: string = '';

  constructor(
    private service: ForgotPassService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm){
    if(!form.valid)
      return;

    this.sendEmail()
    form.reset();
  }

  sendEmail(){
    this.loading = true
    this.service.sendEmail(this.usuario)
      .pipe(
        take(1),
        finalize(() => this.loading = false)
      )
      .subscribe(
        response => alert ('E-mail enviado com sucesso!'),
        error => this.onError(error)
      )
  }

  private onError(error:HttpErrorResponse){
    this.loading = false
    this.msgError = error.error
  }
}
