import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  email: any;
  password: any;
user:User = new User();
  constructor(private authService: AuthService) {}

  ngOnInit(): void {
  }
  
    userLogin()
    { 
      
      console.log(this.user)
     if(this.authService.login(this.user))
        alert("login Succesful")
      
      else 
      alert("Sorry please enter correct user");
    }

}