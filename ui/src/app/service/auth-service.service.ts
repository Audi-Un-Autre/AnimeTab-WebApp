import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SignIn } from '../model/signin';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  // base api user url
  private baseUrl = 'http://localhost:8080/user/login';

  constructor(private http:HttpClient, private router:Router) { }

  authenticateLogin(signIn:SignIn):Observable<any>{

    // json user object to api & json header
    var loginDetails = JSON.stringify( {"email": signIn.getEmail(), "password": signIn.getPassword()} );
    var httpHeader = new HttpHeaders({'Content-Type' : 'application/json'});

    return this.http.post<any>(`${this.baseUrl}`, loginDetails, {headers: httpHeader});
    
  }

  isAuthenticated():boolean{
    let jwtHelper:JwtHelperService = new JwtHelperService();

    const user_token = JSON.parse(localStorage.getItem('user_token')!);

    // token doesn't exist
    if (!user_token)
     return false;
    
    // token exists, check if
    if (user_token && !jwtHelper.isTokenExpired(user_token)) return true;
    else return false;
  }

  deauthorize(){
    // remove token and tell api to deauthorize it ?
    localStorage.removeItem('user_token');
    this.router.navigate(['']);
  }
}
