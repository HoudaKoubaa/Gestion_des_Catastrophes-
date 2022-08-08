import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InterventionService {

  readonly API_URL = 'http://localhost:8089';

  constructor(private httpClient: HttpClient) { }

  
  addIntervention(Answer : any) {
    return this.httpClient.post(`${this.API_URL}/add-intervention`,Answer)
  }

  retrieveAllInterventions() {
    return this.httpClient.get(`${this.API_URL}/retrieve-all-interventions`)
  }

  updateIntervention(intervention : any){
    return this.httpClient.put(`${this.API_URL}/modify-intervention`,intervention)
  }

  deleteIntervention(idIntervention : any){
    return  this.httpClient.delete(`${this.API_URL}/delete-Intervention/${idIntervention}`)
  }

  getInterventionById(idIntervention : any) {
    return this.httpClient.get(`${this.API_URL}/get-Intervention/${idIntervention}`)
  }

}
  