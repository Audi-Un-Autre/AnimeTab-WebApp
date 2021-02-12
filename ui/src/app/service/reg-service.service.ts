import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUp } from '../model/signup';

@Injectable({
  providedIn: 'root'
})
export class RegServiceService {

  private entryURL:string = "http://localhost:8080/user/new";

  constructor(private http: HttpClient) { }

  authNewUser(newUser:SignUp){
    var request = JSON.stringify({"email": newUser.getEmail(), "username": newUser.getUsername(), "password": newUser.getPassword(), "role": "LIMITED"});
    var header = new HttpHeaders({'Content-Type' :  'application/json'});

    // true return -> user exists, false return -> user created
    return this.http.post(`${this.entryURL}`, request, {headers : header, responseType: 'text'});
  }

}
