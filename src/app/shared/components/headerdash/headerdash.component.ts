import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-headerdash',
  templateUrl: './headerdash.component.html',

})
export class HeaderDashComponent implements OnInit {

    @Input()
    message = "Implemente pls"

    updateIcon = '../../../../assets/img/svg/update.svg'
    logoutIcon = '../../../../assets/img/svg/logout.svg'

    constructor() { }

    ngOnInit(): void {
    }

}
