import { Component, OnInit } from '@angular/core';
import { RosterService } from '../roster.service';
import { AuthenticateService } from '../authenticate.service';

import { Gladiator } from '../gladiator';

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

  selectedGladiator = '';
  // gladiators: Array<Gladiator> = [];
  gladiators: any = [];
  ngOnInit() {
    this.rs.getUserGladiators(this.as.getUser().id).subscribe((userObj: Object) => {
      // console.log(userObj);
      this.rs.setGladiators(userObj);

      this.gladiators = userObj;

      // console.log(userObj[0]);
    //});
    // this.gladiators = this.rs.getGladiators();

    // console.log('this.gladiators');
    // console.log(this.gladiators);

      console.log(this.rs.getGladiators());
    });
    // this.makeBox();
  }

  selectGladiator(gid) {
    console.log('selectGladiator(' + gid + ') called');
    this.selectedGladiator = this.gladiators.filter(obj => {
        return obj.id === gid;
    })[0];
    console.log(this.selectedGladiator);
  }

/*
  makeBox() {
    console.log('makeBox');
    return;
  }
*/

}
