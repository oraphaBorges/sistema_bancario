import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-headerdash',
  templateUrl: './headerdash.component.html',

})
export class HeaderDashComponent implements OnInit {

    @Input()
    message = "Implemente pls"

    now = new Date();

    updateIcon = '../../../../assets/img/svg/update.svg';
    logoutIcon = '../../../../assets/img/svg/logout.svg';

    constructor(private router: Router, private authService: AuthService) { }

    ngOnInit(): void {
    }

    doLogout(){
      this.authService.doLogout();
      this.router.navigate(['login']);
    }

    reload(){
      console.log('teste')
      location.reload();
    }
}
