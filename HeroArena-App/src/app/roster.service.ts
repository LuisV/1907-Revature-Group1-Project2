import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Gladiator } from './gladiator';
import { longStackSupport } from 'q';
import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})

// Need to be able to take in a value at '2'
const baseUrl = 'http://localhost:8080/HeroArena/user/roster/';

// let userId = 0;

export class RosterService {

  constructor(private http: HttpClient, private auth: AuthenticateService) { }

  // gladiators: Array<Gladiator> = [];
  gladiators: Array<Gladiator> = [];

  userId = this.auth.getUser()['id'];
  // console.log(userId);


  createGladiator(o): Gladiator {
    let g = new Gladiator();
    g.name = o['name'];
    // TODO
    return g;
  }

  getGladiators() {
    // const header = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    console.log(baseUrl + this.userId);
    const msg = this.http.get(baseUrl + this.userId, {withCredentials: true});
    // console.log('msg: ' + msg);
    // console.log('userId' + (Object.keys(msg)[0])); // [0][1]['player']['id']);
    // console.log('userId: ');
    // console.log(this.userId);
    msg.forEach(element => {
      console.log(element);
      let g = new Gladiator();
      element = Object.entries(element);
      console.log(element);
      // userId = element[0][1]['player']['id'];
      console.log(this.userId);
      // console.log(element[0][1]);
      for (let e in element) {
        console.log(element[e][1]);
        g = this.createGladiator(element[e][1]);
        this.gladiators.push(g);
      }
      console.log(this.gladiators);

      // this works to get the userId
      //console.log(element[0][1]['player']['id']);
    });
  }
}
