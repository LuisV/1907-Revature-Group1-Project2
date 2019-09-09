import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { RosterService } from '../roster.service';
import { AuthenticateService } from '../authenticate.service';

@Component({
  selector: 'app-gladiator-select',
  templateUrl: './gladiator-select.component.html',
  styleUrls: ['./gladiator-select.component.css']
})
export class GladiatorSelectComponent implements OnInit {

  constructor(private rs: RosterService, private as: AuthenticateService) { }

  gladiators: any;
  @Output() targeted = new EventEmitter();

  ngOnInit() {
    this.rs.getUserGladiators(this.as.getUser().id).subscribe((obj: object) => {
      this.gladiators = obj;
      console.log(this.gladiators);
    });
  }

  selectGladiator(gid) {
    console.log('selectGladiator(' + gid + ') called');
    this.targeted.emit(gid);
  }
}
