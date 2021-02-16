import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-headerdash',
  templateUrl: './headerdash.component.html',
  
})
export class HeaderDashComponent implements OnInit {

    message =  "Mensagem do componente :), id='main'"
    updateIcon = '../../../../assets/img/svg/update.svg'
    logoutIcon = '../../../../assets/img/svg/logout.svg'
    
    constructor() { }

  ngOnInit(): void {
  }

}
