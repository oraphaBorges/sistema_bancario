import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-headerdash',
  templateUrl: './headerdash.component.html',

})
export class HeaderDashComponent implements OnInit {

    @Input() message = ""
    nome:string=""
    updateIcon = '../../../../assets/img/svg/update.svg'
    logoutIcon = '../../../../assets/img/svg/logout.svg'
    
    constructor() { }
    
    ngOnInit(): void {
      this.nome = localStorage.getItem('nome')!
      this.message = `Olá ${this.nome}, seja bem vind! ;)`
    }

}
