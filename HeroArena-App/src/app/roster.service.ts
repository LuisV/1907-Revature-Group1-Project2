import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

const url = 'http://localhost:8080/HeroArena/user/roster/2';


export class RosterService {

  constructor(private http: HttpClient) { }


  getGladiators() {
    //const header = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    const msg = this.http.get(url, {withCredentials: true});
    console.log(msg);
    msg.forEach(element => {
      console.log(element);
    });
  }
}
