import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProgrammeService {

  readonly API_URL = 'http://localhost:8089'

  constructor(private httpClient: HttpClient) { }

  addProgramme(programme : any) {
    return this.httpClient.post(`${this.API_URL}/add-programme`,programme)
  }

  retrieveAllProgrammes() {
    return this.httpClient.get(`${this.API_URL}/retrieve-all-programmes`)
  }

  updateProgramme(programme : any){
    return this.httpClient.put(`${this.API_URL}/modify-programme`,programme)
  }

  deleteProgramme(idProgramme : any){
    return  this.httpClient.delete(`${this.API_URL}/delete-programme/${idProgramme}`)
  }

  getProgrammeById(idProgramme : any) {
    return this.httpClient.get(`${this.API_URL}/get-programme/${idProgramme}`)
  }


}
