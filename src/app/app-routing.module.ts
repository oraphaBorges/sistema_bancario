import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountPlanComponent } from './auth/account-plan/account-plan.component';
import { AuthComponent } from './auth/auth.component';
import { DashboardComponent } from './auth/dashboard/dashboard.component';
import { ExtratoComponent } from './auth/extrato/extrato.component';
import { TransactionComponent } from './auth/transaction/transaction.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { Error404Component } from './error404/error404.component';
import { ForgotpassComponent } from './forgotpass/forgotpass.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [{
  path:'dashboard',
  component:AuthComponent,
  children:[{
      path:'',
      component:DashboardComponent,
    },{
      path:'extract',
      component:ExtratoComponent
    },{
      path:'transaction',
      component:TransactionComponent
    },{
      path:'accountplan',
      component:AccountPlanComponent
    }
    ]},{
  path:'',
  component:HomeComponent,
  pathMatch:'full'
},{
  path:'login',
  component:LoginComponent
},{
  path:'forgotpass',
  component:ForgotpassComponent
},{
  path:'changepass',
  component:ChangepassComponent
},{
  path:'**',
  component:Error404Component
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
