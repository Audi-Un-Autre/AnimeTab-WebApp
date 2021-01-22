import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IEntry } from '../model/entry';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntryServiceService {

  private entryUrl = 'http://localhost:8080/user/entries';

  // http request to api url
  constructor(private http: HttpClient) { 
    this.http.get<IEntry[]>(this.entryUrl).toPromise().then(data => {
      console.log(data);
    })
  }

  getEntries(): Observable<IEntry[]>{
    return this.http.get<IEntry[]>(this.entryUrl);
  }
}
