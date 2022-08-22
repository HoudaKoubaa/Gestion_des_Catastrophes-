import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map, Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 private baseUrl="http://localhost:9090/api/v1/registration/login"
  constructor(private httpClient: HttpClient) {

  }
  login(user: User ):Observable<object>
  {
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`,user);
  }
}