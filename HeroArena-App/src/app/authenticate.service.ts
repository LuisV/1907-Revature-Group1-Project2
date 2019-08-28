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
    return this.http.get('jsonplaceholder.typicode.com/users');
  }
}
