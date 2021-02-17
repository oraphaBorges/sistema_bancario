import { Component, OnInit } from '@angular/core';
import { finalize, take } from 'rxjs/operators';
import { IResponseAccountPlan } from './account-plan.interface';
import { AccountPlanService } from './account-plan.service';

@Component({
  selector: 'app-account-plan',
  templateUrl: './account-plan.component.html'
})
export class AccountPlanComponent implements OnInit {

  constructor(private service: AccountPlanService) { }

  message = "Liste e cadastre seus planos de conta aqui :)"
  account_plans: IResponseAccountPlan[] = [];
  loading: boolean = false;
  finalidade: string = '';

  ngOnInit(): void {
    this.getAccountPlans();
  }

  getAccountPlans(){
    this.loading = true;
    this.service.getAccountPlans()
      .pipe(
        take(1),
        finalize(() => this.loading = false)
      )
      .subscribe(
        response => this.account_plans = response,
        error => console.error(error)
      )
  }

  createAccountPlan(){
    this.loading = true;
    if(this.finalidade){
      this.service.createAccountPlan(this.finalidade)
        .pipe(
          take(1),
          finalize(() => this.loading = false)
        ).subscribe()
    } else {
      this.loading = false
    }

    this.getAccountPlans();
  }
}
