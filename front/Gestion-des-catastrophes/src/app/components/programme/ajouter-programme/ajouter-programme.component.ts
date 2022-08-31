import { Component, OnInit } from '@angular/core';
import { Programme } from 'src/app/models/programme';
import { ProgrammeService } from 'src/app/services/programme.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-ajouter-programme',
  templateUrl: './ajouter-programme.component.html',
  styleUrls: ['./ajouter-programme.component.css']
})
export class AjouterProgrammeComponent implements OnInit {

  listProgrammes:any; 
  form:boolean=false;
   programme!:Programme;
   closeResult!:string;
  constructor(private programmeService:ProgrammeService, private modalService: NgbModal) { }

  
  ngOnInit(): void {
    this.getAllProgrammes();

    this.programme = {
      id:null,
      libelleProgramme:null,
      description:null,
      typeProgramme:"ToDo",
      takenBy:null,
    }
  }

  
  getAllProgrammes(){
    this.programmeService.retrieveAllProgrammes().subscribe(res=>this.listProgrammes = res);
  }

  addProgramme(programme : any) {
    console.log("add" +programme.libelleProgramme);
 
    this.programmeService.addProgramme(programme).subscribe(() => {
      this.form = false;
      //return d;
    });
  }
  

  deleteProgramme(idProgramme:any){
    this.programmeService.deleteProgramme(idProgramme).subscribe(()=>this.getAllProgrammes());
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
  

}
