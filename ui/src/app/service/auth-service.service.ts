import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignIn } from '../model/signin';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  // base api user url
  private baseUrl = 'http://localhost:8080/user/login';

  constructor(private http:HttpClient) { }

  authenticateLogin(signIn:SignIn):Observable<boolean>{

    // json user object to api & json header
    var loginDetails = JSON.stringify( {"email": signIn.getEmail(), "password": signIn.getPassword()} );
    var httpHeader = new HttpHeaders({'Content-Type' : 'application/json'});

    return this.http.post<boolean>(`${this.baseUrl}`, loginDetails, {headers: httpHeader});
    
  }
}
