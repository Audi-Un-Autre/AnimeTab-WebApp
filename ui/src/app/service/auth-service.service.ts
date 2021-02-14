import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignIn } from '../model/signin';
//import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  // base api user url
  private baseUrl = 'http://localhost:8080/user/login';

  constructor(private http:HttpClient, /*private jwtHelper:JwtHelperService*/) { }

  authenticateLogin(signIn:SignIn):Observable<any>{

    // json user object to api & json header
    var loginDetails = JSON.stringify( {"email": signIn.getEmail(), "password": signIn.getPassword()} );
    var httpHeader = new HttpHeaders({'Content-Type' : 'application/json'});

    return this.http.post<any>(`${this.baseUrl}`, loginDetails, {headers: httpHeader});
    
  }

  isAuthenticated():boolean{
    const user_token = localStorage.getItem('user_token');
    console.log(user_token);
    if (user_token === "yo") return true; //this.jwtHelper.isTokenExpired(token);
    else return false;
  }

  deauthorize(){
    const token = null;

  }
}
