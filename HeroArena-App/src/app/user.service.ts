import { User } from './user';
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

const baseUrl = 'http://localhost:8080/HeroArena/user';
// const baseUrl = 'http://localhost:8080/HeroArena/user/roster/2';

export class UserService {

  constructor(private http: HttpClient) { }

  getAllUsers() {
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    return this.http.get(url + 'user/all', {headers, withCredentials: true}).pipe(map(resp => resp as User[]));
  }
  updateUser(u: User) {
    const headers = new HttpHeaders({ Accept: 'application/json', 'Content-Type': 'application/json'});
    return this.http.post(url + 'user', u, {headers, withCredentials: true}).pipe(map(resp => resp as User));
  }
}
