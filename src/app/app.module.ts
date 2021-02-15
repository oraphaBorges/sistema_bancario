import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ForgotpassComponent } from './forgotpass/forgotpass.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { Error404Component } from './error404/error404.component';
import { AuthComponent } from './auth/auth.component';
import { DashboardComponent } from './auth/dashboard/dashboard.component';
import { ExtratoComponent } from './auth/extrato/extrato.component';
import { TransactionComponent } from './auth/transaction/transaction.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    ForgotpassComponent,
    ChangepassComponent,
    Error404Component,
    AuthComponent,
    DashboardComponent,
    ExtratoComponent,
    TransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
