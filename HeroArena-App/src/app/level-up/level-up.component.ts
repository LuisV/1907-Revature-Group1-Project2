import { Component, OnInit } from '@angular/core';

import { RosterService } from '../roster.service';
import { RosterDisplayComponent } from '../roster-display/roster-display.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Gladiator } from '../gladiator';

const baseURL = 'http://localhost:8080/HeroArena/';


@Component({
  selector: 'app-level-up',
  templateUrl: './level-up.component.html',
  styleUrls: ['./level-up.component.css']
})


export class LevelUpComponent implements OnInit {

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
      console.log(typeof glad);
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

    // const hdrs = new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'});
    /*
    this.http.put<Gladiator>(  baseURL + '/gladiator',
                    gl,
                    {headers: hdrs}).pipe(map(resp => resp as Gladiator));
    */
    console.log(gl);
    this.http.put<Gladiator>(  baseURL + 'gladiator/update',
                    gl,
                    {headers: hdrs})
                    .subscribe(
                      val => {
                          console.log("PUT call successful value returned in body", 
                                      val);
                      },
                      response => {
                          console.log("PUT call in error", response);
                      },
                      () => {
                          console.log("The PUT observable is now completed.");
                      }
                  );
    console.log('got here');
  }


}
