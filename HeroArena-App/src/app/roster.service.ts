import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Gladiator } from './gladiator';
import { longStackSupport } from 'q';

import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})

const baseUrl = 'http://localhost:8080/HeroArena/user/roster/';

export class RosterService {

  constructor(private http: HttpClient, private auth: AuthenticateService) { }

  gladiators: Array<Gladiator> = [];


  userId = this.auth.getUser()['id'];

  createGladiator(o): Gladiator {
    let g = new Gladiator();
    g.name = o['name'];
    // TODO
    return g;
  }
  getGladiators() {
    // const header = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    // console.log(baseUrl + this.userId);
    const msg = this.http.get(baseUrl + this.userId, {withCredentials: true});

    // console.log('userId' + (Object.keys(msg)[0])); // [0][1]['player']['id']);

    msg.forEach(element => {
      console.log('element:');
      console.log(element);
      let g = new Gladiator();
      // tslint:disable-next-line: forin
      for (let e in element) {
        console.log('element[e]:');
        console.log(element[e]);
        g = this.createGladiator(element[e]);
        this.gladiators.push(g);
      }
      console.log('this.gladiators:');
      console.log(this.gladiators);

      // this works to get the userId
      //console.log(element[0][1]['player']['id']);
    });
  }
}