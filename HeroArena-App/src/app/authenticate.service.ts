import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
import { map } from 'rxjs/operators';

var user = new User();
user.id = -1;

//const baseURL = 'http://localhost:8080/HeroArena/login';
const baseURL = 'http://18.221.9.229:8080/HeroArena/login';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor(private http: HttpClient) { }

  ngOnInit(){}

  checkUser(): Observable<User>{
    const username = (<HTMLInputElement>document.getElementById('username')).value;
    const password = (<HTMLInputElement>document.getElementById('password')).value;
    const formdata = `username=${username}&password=${password}`;
    console.log(formdata);
    const headers = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});

    return this.http.post(baseURL, formdata, {headers: headers, withCredentials: true}).pipe(map(resp => resp as User));
  }

  getUser(){
    // replace with actual http from the backend java
    //return this.http.get('https://jsonplaceholder.typicode.com/users');
    return user;
  }

  setUser(inUser){
    user = inUser;
  }
}
