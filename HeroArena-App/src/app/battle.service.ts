import { Injectable } from '@angular/core';
import { Gladiator } from './gladiator';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

const baseURL = 'http://localhost:8080/HeroArena/';
//const baseURL = 'http://18.221.9.229:8080/HeroArena/';

@Injectable({
  providedIn: 'root'
})
export class BattleService {
  opponentGladiator : Gladiator;
  playerGladiator : Gladiator;

  constructor(private http: HttpClient) { }

  setPlayerGladiator(gladID){
    this.playerGladiator.id = gladID;
  }

  setOpponentGladiator(gladID){
    this.opponentGladiator.id = gladID;
  }

  getPlayerGladiator(){
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

    return this.http.post(baseURL + 'gladiator/opponents', this.playerGladiator.id + '', {headers: headers, withCredentials: true}).pipe(map(resp => resp as Gladiator));
  }

  getOpponentGladiator(){
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

    return this.http.post(baseURL + 'gladiator/opponents', this.opponentGladiator.id + '', {headers: headers, withCredentials: true}).pipe(map(resp => resp as Gladiator));
  }
}
