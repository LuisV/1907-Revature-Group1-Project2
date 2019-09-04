import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { User } from '../user';

var registering = false;
var passError = 0;

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

    if (password == password2 && password.length >= 6 && username.length >= 3) {
      passError = 0;
      const registerString = `username=${username}&password=${password}`;
      console.log(registerString);

      this.authent.addPlayer(registerString).subscribe((userObj: Object) => {
        this.authent.setUser(userObj);
        registering = false;
      })
    }
    
    console.log((passError & 1) + ' ' + (passError & 2) + ' ' + (passError & 4));
    if (password != password2){
      passError = passError | 1;
    }
    else{
      passError = (passError & 2) + (passError & 4);
    }
    console.log(passError);

    if (password.length < 6){
      passError = passError | 2;
    }
    else{
      passError = (passError & 1) + (passError & 4);
    }
    console.log(passError);

    if (username.length < 3){
      passError = passError | 4;
    }
    else{
      passError = (passError & 1) + (passError & 2);
    }

    console.log(passError);
  }

  getPassError(flag){
    return passError & flag;
  }
}
