import { Component, OnInit } from '@angular/core';
import { RosterService } from '../roster.service';

@Component({
  selector: 'app-roster-display',
  templateUrl: './roster-display.component.html',
  styleUrls: ['./roster-display.component.css']
})

/*
function makeGladiatorBox() {
  console.log('makeGladiatorBox');
}
*/
export class RosterDisplayComponent implements OnInit {

  constructor(private rs: RosterService) { }

  ngOnInit() {
    this.rs.getGladiators();
    // this.makeBox();
  }
/*
  makeBox() {
    console.log('makeBox');
    return;
  }
*/

}
