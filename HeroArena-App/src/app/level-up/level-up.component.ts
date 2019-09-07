import { Component, OnInit, Input } from '@angular/core';

import { RosterDisplayComponent } from '../roster-display/roster-display.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
//import {ChangeDetectorRef} from '@angular.core';
import { Gladiator } from '../gladiator';
import { RosterService } from '../roster.service';


const baseURL = 'http://localhost:8080/HeroArena/';


@Component({
  selector: 'app-level-up',
  templateUrl: './level-up.component.html',
  styleUrls: ['./level-up.component.css']
})
// @Input() parent: Component;

export class LevelUpComponent implements OnInit {

  @Input() levelUp: boolean;

  points = 2;

  originalStats = {};

  levelUpGladiator = null;

  constructor(private rdc: RosterDisplayComponent, private http: HttpClient) {
    this.levelUpGladiator = this.rdc.selectedGladiator;
    console.log('in level-up-component: ')
    console.log(this.levelUpGladiator);
    this.originalStats['strength'] = this.levelUpGladiator['strength'];
    this.originalStats['dexterity'] = this.levelUpGladiator['dexterity'];
    this.originalStats['vitality'] = this.levelUpGladiator['vitality'];
    console.log(this.originalStats);
    console.log(this.levelUp);
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
      console.log('levelUp: ' + this.levelUp);
      console.log(this.points);
    }
  }

  subtractPoints(glad, attr) {
    if (this.points >= 2) {
      // do nothing
    } else if (this.originalStats[attr] === this.levelUpGladiator[attr]) {
      // do nothing
    } else {
      // glad['strength'] += 1;
      glad[attr] -= 1;
      this.points++;
      // console.log(pointIn);
      console.log(glad[attr]);
      console.log(this.points);
    }
  }

  submitChanges(gl: Gladiator){
    const hdrs = new HttpHeaders({'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*'});
    console.log(gl);
    if (this.points === 0) {
      gl.level++;
    }
    this.http.put<Gladiator>( baseURL + 'gladiator/update',
                              gl,
                              {headers: hdrs})
    .subscribe(
      val => {
        
        this.levelUp = false;
        console.log('PUT call successful value returned in body', val);
          // this.parent.ngOnInit();
          // attempt 1
          /*
          if (this.points === 0) {
            location.reload();
          }
          */

        // attempt 2
      // this.router.navigateByUrl('/gladiator', {skipLocationChange: true}).then(() => this.router.navigate(["roster"])); 
      },
      response => {
          console.log('PUT call in error', response);
      },
      () => {
          console.log('The PUT observable is now completed.');
      }
  );

}
}