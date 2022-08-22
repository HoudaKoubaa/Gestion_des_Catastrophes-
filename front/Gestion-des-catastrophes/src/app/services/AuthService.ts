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

  login(user: User ):boolean
  { 
    
  let headers = new HttpHeaders();
  headers.append('content-type', 'application/json');
  headers.append('accept', 'application/json');
    if( this.httpClient.post(`${this.baseUrl}`,user, { headers: headers }))
    return true 
    else
    return false

  }
}