import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Intervention } from 'src/app/models/intervention';
import { InterventionService } from 'src/app/services/intervention.service';

@Component({
  selector: 'app-ajouter-intervention',
  templateUrl: './ajouter-intervention.component.html',
  styleUrls: ['./ajouter-intervention.component.css']
})
export class AjouterInterventionComponent implements OnInit {
  listInterventions:any; 
  form:boolean=false;
  intervention!:Intervention;
  closeResult!:string;
  constructor(private interventionService:InterventionService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllInterventions();
    this.intervention = {
      id:null,
      libelleIntervention:null,
      addresseIntervention:null,
      dateIntervention:null,
      intervenant:null
    }

  }

  getAllInterventions(){
    this.interventionService.retrieveAllInterventions().subscribe(res=>this.listInterventions = res);
  }
  
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
    }
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return  `with: ${reason}`;
      }
    }
    closeForm(){
  
    }
    cancel(){
      this.form = false;
    }
    refresh(): void {
      window.location.reload();
  }
}
