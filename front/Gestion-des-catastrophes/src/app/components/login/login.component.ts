import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
user:User = new User();
  constructor(private loginuser: AuthService) {}

  ngOnInit(): void {
  }
  userLogin()
  {
    console.log(this.user)
    this.loginuser.login(this.user).subscribe(data=>{
      alert("login Succesful")
    },error=>alert("Sorry please enter correct user"));
  }


}