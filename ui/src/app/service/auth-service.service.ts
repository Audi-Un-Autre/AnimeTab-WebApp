import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private entryUrl = 'http://localhost:8080/user/all';

  constructor(private http:HttpClient) { }

  // check database for login details
  authLogin(data:any):Observable<any>{
    console.log(data); // testing purposes
    return this.http.post<any>(this.entryUrl,data);
  }
}
