import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SquadService {

  private apiUrl = 'http://localhost:8080/team';  // The base URL for the API

  constructor(private http: HttpClient) { }

  getData(teamId: number): Observable<any> {
    return this.http.get<any>(this.apiUrl + "/getSquad" + "/" + teamId, );  // Adjust endpoint as needed
  }}
