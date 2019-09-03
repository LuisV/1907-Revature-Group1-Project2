import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { User } from '../user';

var registering = false;
var passMatch = true;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authent: AuthenticateService) { }

  ngOnInit() {
  }

  authenticate() {
    this.authent.checkUser().subscribe((userObj: Object) => {
      console.log(userObj);

      this.authent.setUser(userObj);
      // Call user interface
    })
  }

  logout() {
    var user = new User();
    user.id = -1;
    this.authent.setUser(user);
  }

  setRegister() {
    registering = true;
  }

  isRegistering() {
    return registering;
  }

  back() {
    registering = false;
  }

  register() {
    const username = (<HTMLInputElement>document.getElementById('username')).value;
    const password = (<HTMLInputElement>document.getElementById('password1')).value;
    const password2 = (<HTMLInputElement>document.getElementById('password2')).value;

    if (password == password2) {
      passMatch = true;
      const registerString = `username=${username}&password=${password}`;
      console.log(registerString);

      this.authent.addPlayer(registerString).subscribe((userObj: Object) => {
        this.authent.setUser(userObj);
      })
    }
    else {
      passMatch = false;
    }
  }

  getPassMatch(){
    return passMatch;
  }
}
