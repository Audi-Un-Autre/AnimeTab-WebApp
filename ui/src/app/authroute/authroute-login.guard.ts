import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthServiceService } from '../service/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthrouteLoginGuard implements CanActivate {

  constructor(private auth:AuthServiceService, private router:Router){}


  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> |  Promise<boolean> | boolean {

    //not logged in/token expired
    if (!this.auth.isAuthenticated()){
      this.router.navigate(['']);
      console.log("redirect homepage");
      return false;
    } 

    //logged in/token active
    console.log("reidrect user page");
    return true;
  }

}