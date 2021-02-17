import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-headerdash',
  templateUrl: './headerdash.component.html',

})
export class HeaderDashComponent implements OnInit {


    constructor(private router: Router, private authService: AuthService) { }
  
    now = new Date();

    @Input() message = ""
    nome:string=""
    updateIcon = '../../../../assets/img/svg/update.svg'
    logoutIcon = '../../../../assets/img/svg/logout.svg'
        
    ngOnInit(): void {
      this.nome = localStorage.getItem('nome')!
      this.message = `Olá ${this.nome}, seja bem vind! ;)`
    }

    doLogout(){
      this.authService.doLogout();
      this.router.navigate(['login']);
    }

    reload(){
      location.reload();
    }
}
