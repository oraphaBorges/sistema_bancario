import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivateChild, Router, RouterStateSnapshot } from "@angular/router";

@Injectable()
export class AuthGuard implements CanActivateChild {

    constructor(private router: Router) { }

    canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        let token = localStorage.getItem('token');
        let dataFim = localStorage.getItem('dataFim');

        //DESCOMENTAR ESSE CÓDIGO QUANDO APLICARMOS A LÓGICA DE LOGIN
        //JÁ FOI TESTADO E VALIDADO
        // if(!token || !dataFim){
        //     this.router.navigate(['login']);

        //     return false;
        // }

        // token = JSON.parse(token);
        // dataFim = JSON.parse(dataFim);

        // const tokenFinalDate = new Date(dataFim!);
        // const now = new Date();

        // if(now < tokenFinalDate){
        //     this.router.navigate(['login']);

        //     return false;
        // }

        return true;
    }
}
