import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { User } from '../user';

var registering = false;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authent: AuthenticateService) { }

  ngOnInit() {
  }

  authenticate(){
    this.authent.checkUser().subscribe((userObj: Object)=>{
      console.log(userObj);

      this.authent.setUser(userObj);
      // Call user interface
    })
  }

  logout(){
    var user = new User();
    user.id = -1;
    this.authent.setUser(user);
  }

  register(){
    console.log(registering);
    registering = true;
    console.log(registering);
  }
}
