import { Component, OnInit } from '@angular/core';
import {Weather} from "../../models/weather";
import {WeatherService} from "../../services/weather.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  mywaether:any;
  form:boolean=false;
  closeResult!:string;
  weather!:Weather;
  constructor(private weatherservice: WeatherService, private modalService: NgbModal) { }

  ngOnInit(): void {
    console.log("hello from here ");
  //  this.getweather(this.weather);
    this.weather={
      idweather:null,
      id:null,
      weatherDescription:null,
      lon:null,
      name:null,
      lat:null,
      temp_min:null,
      temp_max:null,
      humidity:null,
      temp:null,
      icon:null,
      speed:null,
    }
  }

  getweather(weather:any,name:any){
    this.weatherservice.weatherget(weather, name).subscribe(res => this.mywaether = res);
    console.log(this.weather )
  }



}
