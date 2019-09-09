import { User } from './user';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { longStackSupport } from 'q';
import { AuthenticateService } from './authenticate.service';


// const url = 'http://localhost:8080/HeroArena/';
const url = 'http://18.221.9.229:8080/HeroArena/';

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
