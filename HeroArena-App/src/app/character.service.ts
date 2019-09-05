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
const url = 'http://localhost:8080/HeroArena/';

const baseUrl = 'http://localhost:8080/HeroArena/user/roster/';
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
}
