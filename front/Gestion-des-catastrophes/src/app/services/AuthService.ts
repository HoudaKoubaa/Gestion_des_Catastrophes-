import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map, Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    public email: any;
    public password: any;
    public test!: any;
 private baseUrl="http://localhost:9090/api/v1/registration/login"
 
  constructor(private httpClient: HttpClient) {


  }
  user:User = new User();
  login(user:User):Observable<object>
  {
    // save the username to session
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`,user);
  }
} 