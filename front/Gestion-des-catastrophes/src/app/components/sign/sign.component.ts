import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { SignService } from 'src/app/services/sign.service';

@Component({
  selector: 'app-sign',
  templateUrl: './sign.component.html',
  styleUrls: ['./sign.component.css']
})
export class SignComponent implements OnInit {
test:any;
message:any;
  user:User = new User();
  constructor(private loginuser: SignService,private router:Router) { }

  ngOnInit(): void {
  }
  userSign()
  { 
    let resp = this.loginuser.Sign(this.user);
    this.test= (resp.subscribe(data=>
        { this.message = data
         this.router.navigate(["/signup"])},
         (error) => {                              //Error callback
          alert("Votre coordonnées est erronée")})
    );
   

  }
}