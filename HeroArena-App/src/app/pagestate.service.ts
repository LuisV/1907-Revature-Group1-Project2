import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PagestateService {

  constructor() { }

  state = 0;

  getState(){
    return this.state;
  }  

  setState(inState){
    this.state = inState;
  }
}
