import {Component, OnInit} from '@angular/core';
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Alert} from "../../models/Alert";
import {AlertService} from "../../services/alert.service";
import {Niveau} from "../../models/niveau";
import {Type_tempete} from "../../models/type-tempete";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  listAlert:any;
  form:boolean=false;
  alert!:Alert;
  closeResult!:string;
  constructor(private alertService: AlertService, private modalService: NgbModal) {
  }
  ngOnInit(): void {
   this.getAllAlert();
    this.alert={
      id:null,
      Ville: null,
      niveau:Niveau.Bas,
      type_tempete: Type_tempete.Cyclone,
      description:null,
      date :null}

  }
  getAllAlert(){
    console.log("hello");
    this.alertService.getAlert().subscribe(res => this.listAlert = res)
  }

  addAlert(alert:any){
    this.alertService.addAlert(alert).subscribe(res => this.listAlert = res)
  }
  deleteLocal(idLocal: any) {
    this.alertService.deleteAlert(idLocal).subscribe(()=> this.getAllAlert());
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
