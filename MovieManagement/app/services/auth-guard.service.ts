import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private authservice: AuthenticationService, private router: Router) {

  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    
    if (this.authservice.isUserLoggedIn()) {
      // route : additional info about request(component) being generated
      // route.url
      this.router.navigate(['/home']);
      return true;
    } else {
      // navigate to login component
      this.router.navigate(['/login']);
      return false;
    }

  }
}
