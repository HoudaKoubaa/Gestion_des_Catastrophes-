import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
readonly API_URL = 'http://localhost:8089'

  constructor(private httpClient: HttpClient) { }

  weatherget(weather:any , name:any){
      return this.httpClient.post(`${this.API_URL}/weather/${name}`,weather)
  }


}
