import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

//Guards

import { NotAuthGuard } from './shared/guards/not-auth/not-auth.guard';

//components
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
import { AuthGuard } from './shared/services/guards/auth.guard';

const routes: Routes = [
  {
    path:'dashboard',
    component:AuthComponent,
    canActivateChild:[AuthGuard],
    children: [
      {
        path:'main',
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
      }]
    },{
    path:'',
    component:HomeComponent,
    canActivateChild:[NotAuthGuard],
    pathMatch:'full'
  },{
    path:'login',
    component:LoginComponent,
    canActivateChild:[NotAuthGuard],
  },{
    path:'forgotpass',
    component:ForgotpassComponent,
    canActivateChild:[NotAuthGuard],
  },{
    path:'changepass',
    component:ChangepassComponent,
    canActivateChild:[NotAuthGuard],
  },{
    path:'**',
    component:Error404Component
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
