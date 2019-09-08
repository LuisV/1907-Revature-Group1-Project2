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

  levelUp = false;

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

  setLevelUp(lu) {
    lu = !lu;
    return lu;
  }

  getLevelUp() {
    return this.levelUp;
  }

  selectGladiator(gid) {
    console.log('selectGladiator(' + gid + ') called');
    this.selectedGladiator = this.gladiators.filter(obj => {
        return obj.id === gid;
    })[0];
    console.log(this.selectedGladiator);
    console.log(this.selectedGladiator['name']);
    this.levelUp = this.determineLevelUp(this.selectedGladiator);
  }


  determineLevelUp(glad) {
    let totalExpForNextLevel = Math.floor(5 * (Math.pow((glad['level'] + 1), 3)) / 4);
    return glad['experience'] > totalExpForNextLevel;

  }

}
