import { Component, OnInit } from '@angular/core';
import {Weather} from "../../models/weather";
import {WeatherService} from "../../services/weather.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import { FormBuilder, FormGroup } from '@angular/forms';
import {ApixuService} from "../../apixu.service";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  public weatherData: any;

  mywaether:any;
  form:boolean=false;
  closeResult!:string;
  weather!:Weather;
  constructor(    private apixuService: ApixuService
  ,private weatherservice: WeatherService, private modalService: NgbModal,private formBuilder: FormBuilder) {
  }
  public weatherSearchForm!: FormGroup;
  ngOnInit(): void {
   // this.weatherSearchForm = this.formBuilder.group({location: ['']});
  //  this.getweather(this.weather, this.weather.name);
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
    console.log("hello from here ");

  }

  getweather(weather: any, city: any){
    this.weatherservice.weatherget(weather, city).subscribe(res => this.mywaether = res);
    console.log(this.weather )
  }
  sendToAPIXU(formValues:any){
    this.apixuService
      .getWeather(formValues.location)
      .subscribe(data => this.weatherData = data)
    console.log(this.weatherData);
  }


}
