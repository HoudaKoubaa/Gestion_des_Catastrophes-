import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
readonly API_URL = 'http://localhost:8089/a'

  constructor(private httpClient: HttpClient) { }

  weatherget(weather:any , city:any){
      return this.httpClient.post(`${this.API_URL}/weather/${city}`,weather)
  }


}
