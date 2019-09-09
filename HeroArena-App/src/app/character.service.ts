import { Character } from './character';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { longStackSupport } from 'q';
import { AuthenticateService } from './authenticate.service';


//@Injectable({
 // providedIn: 'root'
//})

// Need to be able to take in a value at '2'
// const url = 'http://localhost:8080/HeroArena/user/roster/2';
const url = 'http://18.221.9.229:8080/HeroArena/';


// const url = 'http://localhost:8080/HeroArena/user/roster/2';
// const baseUrl = 'http://localhost:8080/HeroArena/user/roster/2';

export class CharacterService {

  constructor(private http: HttpClient) { }

  allCharacters: Array<Character> = [];

  getCharacters() {
    return this.allCharacters;
  }

  getAllCharacters() {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.get(url + 'character/all', {headers, withCredentials: true}).pipe(map(resp => resp as Character[]));
  }
  updateCharacter(ch: Character) {
    const headers = new HttpHeaders({ Accept: 'application/json', 'Content-Type': 'application/json'});
    return this.http.post(url + 'character', ch, {headers, withCredentials: true}).pipe(map(resp => resp as Character));
  }
  createCharacter(ch: Character) {
    const headers = new HttpHeaders({ Accept: 'application/json', 'Content-Type': 'application/json'});
    return this.http.put(url + 'character', ch, {headers, withCredentials: true}).pipe(map(resp => resp as Character));
  }
  deleteCharacter(ch: Character){
    const options = { headers: new HttpHeaders({ Accept: 'application/json', 'Content-Type': 'application/json'}), body: ch,
    withCredentials: true };
    return this.http.delete(url + 'character', options);
  }
}
