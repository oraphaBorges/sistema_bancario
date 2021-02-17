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

  account_plans: IResponseAccountPlan[] = [];
  loading: boolean = false;

  ngOnInit(): void {
    this.loading = true;
    this.getAccountPlans();
  }

  getAccountPlans(){
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

}
