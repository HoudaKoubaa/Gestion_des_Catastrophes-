import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
    public username: any;
    public password: any;

  constructor(private http: HttpClient) {

  }

  login(username: any, password: any) {
    return this.http.get(environment.hostUrl + 'api/v1/registration/list-user',
      { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin(username, password);
      }));
  }

  createBasicAuthToken(username: any, password: any) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  registerSuccessfulLogin(username:any,password:any)
  {
    // save the username to session
  }
}