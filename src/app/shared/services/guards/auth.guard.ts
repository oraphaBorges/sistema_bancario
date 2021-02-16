import { Injectable } from "@angular/core";
import { CanActivateChild, Router } from "@angular/router";
import { AuthService } from "../auth/auth.service";

@Injectable()
export class AuthGuard implements CanActivateChild {

    constructor(private router: Router, private authService: AuthService) { }

    canActivateChild(): boolean{
        const isLogged = this.authService.isLoggedIn();

        if(isLogged)
            return true

        this.router.navigate(['login']);

        return false;
    }
}
