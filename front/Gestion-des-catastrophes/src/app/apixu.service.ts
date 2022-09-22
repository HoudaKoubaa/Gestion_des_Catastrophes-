import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApixuService {

  constructor(private http: HttpClient) { }

  getWeather(location:any){
    return this.http.get(
      'https://api.apixu.com/v1/current.json?key=a471a412881fc123c8bbd3d1613063a8&q=' + location
    );
  }
}
