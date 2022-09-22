import { Component, OnInit } from '@angular/core';
import {Alert} from "../../../models/Alert";
import {AlertService} from "../../../services/alert.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Niveau} from "../../../models/niveau";
import {Type_tempete} from "../../../models/type-tempete";
import {animate} from "@angular/animations";

@Component({
  selector: 'app-list-alert',
  templateUrl: './list-alert.component.html',
  styleUrls: ['./list-alert.component.css']
})
export class ListAlertComponent implements OnInit {
  listAlert:any;
  form:boolean=false;
  alert!:Alert;
  closeResult!:string;
  constructor(private alertService: AlertService, private modalService: NgbModal,constructor: Function) {
    constructor.prototype.MyEnum = Niveau;
  }

  ngOnInit(): void {
    this.getAllAlert();
   /* this.alert={
      id:null,
      Ville: null,
      niveau: null,
      type_tempete: null,
      description:null,
      date :null
    }*/

  }

  getAllAlert(){
    this.alertService.getAlert().subscribe(res => this.listAlert = res)
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
