import { Component, OnInit } from '@angular/core';

import { RosterService } from '../roster.service';
import { RosterDisplayComponent } from '../roster-display/roster-display.component';

@Component({
  selector: 'app-level-up',
  templateUrl: './level-up.component.html',
  styleUrls: ['./level-up.component.css']
})
export class LevelUpComponent implements OnInit {

  points = 2;

  originalStats = {};

  levelUpGladiator = null;

  constructor(private rdc: RosterDisplayComponent) {
    this.levelUpGladiator = this.rdc.selectedGladiator;
    console.log('in level-up-component: ')
    console.log(this.levelUpGladiator);
    this.originalStats['strength'] = this.levelUpGladiator['strength'];
    this.originalStats['dexterity'] = this.levelUpGladiator['dexterity'];
    this.originalStats['vitality'] = this.levelUpGladiator['vitality'];
    console.log(this.originalStats);
  }

  ngOnInit() {
  }


  addPoints(glad, attr) {
    if (this.points <= 0) {

    } else {
      // glad['strength'] += 1;
      glad[attr] += 1;
      this.points--;
      // console.log(pointIn);
      console.log(glad[attr]);

      console.log(this.points);
    }
  }

  subtractPoints(glad, attr) {
    if (this.points >= 2) {

    } else if (this.originalStats[attr] === this.levelUpGladiator[attr]) {

    } else {
      // glad['strength'] += 1;
      glad[attr] -= 1;
      this.points++;
      // console.log(pointIn);
      console.log(glad[attr]);

      console.log(this.points);
    }
  }


}
