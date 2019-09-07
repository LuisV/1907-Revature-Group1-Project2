import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { User } from '../user';
import { PagestateService} from '../pagestate.service';

var registering = false;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private errorString = '';
  constructor(private authent: AuthenticateService, private pss: PagestateService) { }

  ngOnInit() {
  }

  authenticate() {
    const username = (<HTMLInputElement>document.getElementById('username')).value;
    const password = (<HTMLInputElement>document.getElementById('password')).value;
    const formdata = `username=${username}&password=${password}`;

    this.errorString = '';

    this.authent.checkUser(formdata).subscribe((userObj: Object) => {
      console.log(userObj);

      if (userObj != null) {
        this.authent.setUser(userObj);

        if (this.authent.getUser().id == -2) {
          this.errorString = 'You are banned.';
          this.authent.getUser().id = -1;
        }
      }
      else
        this.errorString = 'Invalid username or password.';
    })
  }

  logout() {
    var user = new User();
    user.id = -1;
    this.pss.setState(1);
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

    this.errorString = '';

    if (password == password2 && password.length >= 6 && username.length >= 3) {
      const registerString = `username=${username}&password=${password}`;
      console.log(registerString);

      this.authent.addPlayer(registerString).subscribe((userObj: Object) => {
        this.authent.setUser(userObj);
        registering = false;
      })
    }


    if (username.length < 3) {
      this.errorString += 'Your username needs to be at least 3 characters.';
    }

    if (password != password2) {
      this.errorString += '<br>Passwords did not match, please re-enter.';
    }

    if (password.length < 6) {
      this.errorString += '<br>The password needs to be at least 6 characters.';
    }
  }

  onKeydownRegister(event) {
    //console.log(event);

    if (event.key === "Enter") {
      this.register();
    }

    //console.log(this.keys);
  }

  onKeydownLogin(event) {
    //console.log(event);

    if (event.key === "Enter") {
      this.authenticate();
    }

    //console.log(this.keys);
  }
}
