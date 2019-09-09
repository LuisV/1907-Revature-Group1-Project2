import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Gladiator } from './gladiator';
import { map } from 'rxjs/operators';
import { longStackSupport } from 'q';
import { AuthenticateService } from './authenticate.service';


const url = 'http://18.221.9.229:8080/HeroArena/';

//const url = 'http://localhost:8080/HeroArena/';

let userId = 0;

export class RosterService {

  constructor(private http: HttpClient, private auth: AuthenticateService) { }

  gladiators: Array<Gladiator> = [];
  private selectedGladiator: Gladiator;


  userId = this.auth.getUser()['id'];

  // This was some preliminary code to get the Gladiators in an unsafe manner.
  /*getGladiators() {
    // const header = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    // console.log(baseUrl + this.userId);
    const msg = this.http.get(baseUrl + this.userId, {withCredentials: true});

    // console.log('userId' + (Object.keys(msg)[0])); // [0][1]['player']['id']);

    msg.forEach(element => {
      // console.log('element:');
      // console.log(element);
      let g = new Gladiator();
      // tslint:disable-next-line: forin
      for (let e in element) {
        // console.log('element[e]:');
        // console.log(element[e]);
        g = this.createGladiator(element[e]);
        this.gladiators.push(g);
      }
      // console.log('this.gladiators:');
      // console.log(this.gladiators);

      // this works to get the userId
      // console.log(element[0][1]['player']['id']);
    });
  }*/

  setGladiators(gladiatorList) {
    this.gladiators = gladiatorList;
  }

  getGladiators() : Array <Gladiator>{
    return this.gladiators;
  }

  setSelectedGladiator(gladiator){
    this.selectedGladiator = gladiator;
  }

  getSelectedGladiator(){
    return this.selectedGladiator;
  }

  getUserGladiators(userID) {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.post(url + 'gladiator', 'id=' + userID, {headers: headers, withCredentials: true}).pipe(map(resp => resp as Gladiator[]));
  }
}
