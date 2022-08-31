import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class SignService {
  
  private baseUrl="http://localhost:9090/api/v1/registration"
 
  constructor(private httpClient: HttpClient) {
  }
  user:User = new User();
  Sign(user:User):Observable<object>
  {
    // save the username to session
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`,user);
  }
}
