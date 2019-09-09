import { Injectable } from '@angular/core';
import { Gladiator } from './gladiator';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { AuthenticateService } from './authenticate.service';

const baseURL = 'http://localhost:8080/HeroArena/';
//const baseURL = 'http://18.221.9.229:8080/HeroArena/';

@Injectable({
  providedIn: 'root'
})
export class BattleService {
  opponentGladiator : Gladiator;
  playerGladiator : Gladiator;

  constructor(private http: HttpClient, private as: AuthenticateService) { }

  private playersChosen = false;

  setPlayersChosen(setBool: boolean){
    this.playersChosen = setBool;
  }

  getPlayersChosen(){
    return this.playersChosen;
  }

  setPlayerGladiator(gladiator: Gladiator){
    this.playerGladiator = gladiator;
  }

  getPlayerGladiator(){
    return this.playerGladiator;
  }

  getOpponentGladiator(){
    return this.opponentGladiator;
  }

  setOpponentGladiator(gladiator: Gladiator){
    this.opponentGladiator = gladiator;
  }

  getOpponentGladiators(){
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

    return this.http.get(baseURL + 'gladiator/opponents', {headers, withCredentials: true}).pipe(map(resp => resp as Gladiator[]));
    //return this.http.post(baseURL + 'opponents', 'user=' + this.as.getUser(), {headers : headers, withCredentials: true}).pipe(map(resp => resp as Gladiator[]));
  }
}
