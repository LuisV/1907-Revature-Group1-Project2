import { UserService } from './../../user.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit, Input } from '@angular/core';
import {User} from 'src/app/user';
@Component({
  selector: 'app-user-item',
  templateUrl: './user-item.component.html',
  styleUrls: ['./user-item.component.css']
})
export class UserItemComponent implements OnInit {

  @Input() public id: number;
  @Input() public username: string;
  @Input() public password: string;
  @Input() public banned: number;
  @Input() public role: number;

  constructor(private us: UserService) { }

  ngOnInit() {
  }

  onSubmit(userFrom: NgForm){
    const u =  new User(this.id, this.username, this.password, this.banned, this.role);
    this.us.updateUser(u).subscribe(() => {
      userFrom.reset();
    });
  }
}
