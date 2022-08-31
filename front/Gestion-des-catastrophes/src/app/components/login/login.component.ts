import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
 
  test: any;
  email: any;
  password: any;
  message !:any;
  user:User = new User();
  constructor(private loginuser: AuthService,private router:Router) { }

  ngOnInit(): void {
  }
  
    userLogin()
    { 
     
    let resp = this.loginuser.login(this.user);
    this.test= (resp.subscribe(data=>
        { this.message = data
         this.router.navigate(["/home"])},
         (error) => {                              //Error callback
          alert("Sorry please enter correct user")})
    );
   
        
      }

      

}