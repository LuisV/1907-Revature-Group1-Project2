import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';

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
    this.authent.getUser().subscribe((userObj: Object)=>{
      console.log(userObj);
    })
  }
}
