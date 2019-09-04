import { Component, OnInit } from '@angular/core';
import { RosterService } from '../roster.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  constructor(private rs: RosterService) { }

  ngOnInit() {
  }


  showHeroes() {

    console.log('showHeroes() called');
    this.rs.getGladiators();
  }
}
