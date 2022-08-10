import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/AuthService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  username: any;
  password: any;
  successMessage: any;
  errorMessage = 'Invalid Credentials';
  router:any;
  
  invalidLogin = false;
  loginSuccess = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
  }

  handleLogin() {
    this.authService.login(this.username, this.password).subscribe((result) => {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful';

      this.router.navigate(['/home/']) 
        }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }

}