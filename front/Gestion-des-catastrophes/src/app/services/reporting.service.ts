import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReportingService {

  readonly API_URL = 'http://localhost:8089'

  constructor(private httpClient: HttpClient) { }

  
  addReporting(reporting : any) {
    return this.httpClient.post(`${this.API_URL}/add-reporting`,reporting)
  }

  retrieveAllReports() {
    return this.httpClient.get(`${this.API_URL}/retrieve-all-reports`)
  }

  updateReporting(reporting : any){
    return this.httpClient.put(`${this.API_URL}/"modify-report`,reporting)
  }

  deleteReporting(idReport : any){
    return  this.httpClient.delete(`${this.API_URL}/delete-report/${idReport}`)
  }

  getProgrammeById(idReport : any) {
    return this.httpClient.get(`${this.API_URL}/get-report/${idReport}`)
  }

}
