import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StandingsService {

  private apiUrl = 'http://localhost:8080/season';  

  constructor(private http: HttpClient) { }

  getTotalTable(season: string): Observable<any> {
    console.log("getting data from backend");
    return this.http.get<any>(this.apiUrl + "/TableEntries" + "/" + season); 
  }

  getHomeTable(season: string): Observable<any> {
    return this.http.get<any>(this.apiUrl + "/TableEntriesHome" + "/" + season); 
  }

  getAwayTable(season: string): Observable<any> {
    return this.http.get<any>(this.apiUrl + "/TableEntriesAway" + "/" + season); 
  }

}

