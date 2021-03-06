import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IEntry } from '../model/entry';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EntryServiceService {

  private entryUrl = 'http://localhost:8080/entry/all';

  constructor(private http: HttpClient) { }

  getEntries(): Observable<IEntry[]>{
    return this.http.get<IEntry[]>(this.entryUrl);
  }
}
