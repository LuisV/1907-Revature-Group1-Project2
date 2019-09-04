import { Component, OnInit } from '@angular/core';
import { RosterService } from '../roster.service';
import { AuthenticateService } from '../authenticate.service';

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

  constructor(private rs: RosterService, private as: AuthenticateService) { }

  ngOnInit() {
    //this.rs.getGladiators();
    this.rs.getUserGladiators(this.as.getUser().id).subscribe((userObj: Object) => {
      console.log(userObj);
      this.rs.setGladiators(userObj);
      console.log(this.rs.getGladiators());
    })
    // this.makeBox();
  }
/*
  makeBox() {
    console.log('makeBox');
    return;
  }
*/

}
