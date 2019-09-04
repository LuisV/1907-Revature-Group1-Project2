import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Gladiator } from './gladiator';
import { map } from 'rxjs/operators';

//@Injectable({
 // providedIn: 'root'
//})

// Need to be able to take in a value at '2'
//const url = 'http://localhost:8080/HeroArena/user/roster/2';
const url = 'http://localhost:8080/HeroArena/';


export class RosterService {

  constructor(private http: HttpClient) { }

  // gladiators: Array<Gladiator> = [];
  gladiators = [];

  getGladiators() {
    // const header = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    const msg = this.http.get(url, {withCredentials: true});
    console.log(msg);
    msg.forEach(element => {
      console.log(element);
      let g = new Gladiator();

      // g.name = element['name'];
      // tslint:disable-next-line: forin

      console.log(element);

      this.gladiators.push(element);
    });
  }

  
  getUserGladiators(userID) {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.post(url + 'gladiator', 'id=' + userID, {headers: headers, withCredentials: true}).pipe(map(resp => resp as Gladiator[]));
  }
}
