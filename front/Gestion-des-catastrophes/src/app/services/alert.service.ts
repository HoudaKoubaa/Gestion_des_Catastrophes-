import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AlertService {
  readonly API_URL = 'http://localhost:8089/alerts'

  constructor(private httpClient: HttpClient) { }

  getAlert(){
    return this.httpClient.get(`${this.API_URL}/findall`)
  }

  addAlert(alert:any){
    return this.httpClient.post(`${this.API_URL}/alert`,alert)
  }

  deleteAlert(id:any){
    return this.httpClient.delete(`${this.API_URL}/alert/${id}`      )

  }
}
