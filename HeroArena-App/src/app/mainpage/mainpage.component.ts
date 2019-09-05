import { Component, OnInit } from '@angular/core';
import { RosterDisplayComponent } from '../roster-display/roster-display.component';
import { RosterService} from '../roster.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  
  constructor(private rs: RosterService) { }
  state = 0;

  ngOnInit() {
  }

  showHeroes() {
    console.log('showHeroes() called');
    //this.rs.getGladiators();
    this.state = 1;
  }

  showBattle(){
    this.state = 3;
  }

  getState(){
    return this.state;
  }  

  setState(inState){
    this.state = inState;
  }
}
