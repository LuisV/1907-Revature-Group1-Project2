import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: any;
  constructor(private us: UserService) { }

  ngOnInit() {
    this.us.getAllUsers().subscribe((obj:Object)=> {
      this.users = obj;
      console.log(obj);
    });
  }

}
