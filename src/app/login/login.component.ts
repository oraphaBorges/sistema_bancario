import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  //capturar dados para realizar login
  private doLogin(){
    let data = {
      usuario: 'emersonteste',
      senha: 'emersonteste'
    }

    this.userService.doLogin(data);
  }

}
