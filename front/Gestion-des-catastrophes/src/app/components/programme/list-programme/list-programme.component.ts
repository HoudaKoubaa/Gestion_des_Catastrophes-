import { Component, OnInit } from '@angular/core';
import { Programme } from 'src/app/models/programme';
import { ProgrammeService } from 'src/app/services/programme.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-list-programme',
  templateUrl: './list-programme.component.html',
  styleUrls: ['./list-programme.component.css']
})
export class ListProgrammeComponent implements OnInit {
  listProgrammes:any; 
  form:boolean=false;
   programme!:Programme;
   closeResult!:string;

  constructor(private programmeService:ProgrammeService, private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  getAllProgrammes(){
    this.programmeService.retrieveAllProgrammes().subscribe(res=>this.listProgrammes = res);
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
