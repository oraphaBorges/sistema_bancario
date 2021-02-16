//angular
import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { registerLocaleData } from '@angular/common';
import { FormsModule } from '@angular/forms';
import localePtBr from '@angular/common/locales/pt';

//services
import { DashboardService } from './services/dashboard.service';
import { UserService } from './services/user.service';
import { AuthService } from './shared/services/auth/auth.service';
import { TransactionService } from './auth/transaction/transaction.service';

//modules
import { AppRoutingModule } from './app-routing.module';

//components
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
import { AccountPlanComponent } from './auth/account-plan/account-plan.component';
import { BlocoCelularesComponent } from './home/bloco-celulares/bloco-celulares.component';
import { BlocoAnuidadeComponent } from './home/bloco-anuidade/bloco-anuidade.component';
import { BlocoCadastroLoginComponent } from './home/bloco-cadastro-login/bloco-cadastro-login.component';
import { FormCadastroComponent } from './home/bloco-cadastro-login/form-cadastro/form-cadastro.component';
import { BlocoLoginComponent } from './home/bloco-cadastro-login/bloco-login/bloco-login.component';
import { BlocoFooterComponent } from './home/bloco-footer/bloco-footer.component';
import { BlocoFimComplexidadeComponent } from './home/bloco-fim-complexidade/bloco-fim-complexidade.component';
import { NavComponent } from './shared/components/nav/nav.component';
import { NavDashboardComponent} from './shared/components/navdashboard/navdashboard.component';
import { HeaderDashComponent } from './shared/components/headerdash/headerdash.component';

registerLocaleData(localePtBr, 'pt-br')

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
    TransactionComponent,
    AccountPlanComponent,
    BlocoLoginComponent,
    BlocoCelularesComponent,
    BlocoAnuidadeComponent,
    BlocoFimComplexidadeComponent,
    BlocoCadastroLoginComponent,
    FormCadastroComponent,
    BlocoFooterComponent,
    NavComponent,
    NavDashboardComponent,
    HeaderDashComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [
    DashboardService,
    UserService,
    AuthService,
    TransactionService,
    {
      provide:LOCALE_ID,
      useValue:'pt-br'
    },
    {
      provide:DEFAULT_CURRENCY_CODE,
      useValue:'BRL'
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
