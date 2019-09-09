import { Component, OnInit } from '@angular/core';
import { RosterDisplayComponent } from '../roster-display/roster-display.component';
import { RosterService} from '../roster.service';
import { PagestateService} from '../pagestate.service';
import { AuthenticateService} from '../authenticate.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  
  constructor(private rs: RosterService, private pss: PagestateService, private as: AuthenticateService) { }

  ngOnInit() {
    this.pss.setState(0);
  }

  showHeroes() {
    //console.log('showHeroes() called');
    //this.rs.getGladiators();
    window.document.querySelector('body').style.overflow = 'visible';
    this.pss.setState(1);
  }

  showEquip(){
    window.document.querySelector('body').style.overflow = 'visible';
    this.pss.setState(2);
  }

  showBattle(){
    window.document.querySelector('body').style.overflow = 'hidden';
    this.pss.setState(3);
  }

  showShop(){
    window.document.querySelector('body').style.overflow = 'visible';
    this.pss.setState(4);
  }

  showManageUsers(){
    this.pss.setState(5);
  }

  showManageChars(){
    this.pss.setState(6);
  }
}
