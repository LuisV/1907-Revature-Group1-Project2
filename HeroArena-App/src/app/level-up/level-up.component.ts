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

  levelUpGladiator = null;

  constructor(private rdc: RosterDisplayComponent) {
    this.levelUpGladiator = this.rdc.selectedGladiator;
    console.log('in level-up-component: ')
    console.log(this.levelUpGladiator);
  }

  ngOnInit() {
  }


  assignPoints(pointIn) {
    console.log(pointIn);
    while (this.points >= 0) {
      this.points--;
      console.log(this.points);
    }
  }


}
