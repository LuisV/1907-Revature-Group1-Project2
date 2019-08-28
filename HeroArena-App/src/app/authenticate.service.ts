import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseURL = '';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor(private http: HttpClient) { }

  ngOnInit(){}

  checkUser(username, password){
    const formdata = new FormData
    formdata.append('username', username);
    formdata.append('password', password);
    const options = {responseType: 'text' as 'text'};

    return this.http.post(baseURL+"login", formdata, options)
  }

  getUser(){
    // replace with actual http from the backend java
    return this.http.get('https://jsonplaceholder.typicode.com/users');
  }
}
