import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { BodyComponent } from './components/shared/body/body.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ListReportingComponent } from './components/reporting/list-reporting/list-reporting.component';
import { ListProgrammeComponent } from './components/programme/list-programme/list-programme.component';
import { ListInterventionComponent } from './components/intervention/list-intervention/list-intervention.component';
@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    BodyComponent,
    FooterComponent,
    HomeComponent,
    NotFoundComponent,
    ListReportingComponent,
    ListProgrammeComponent,
    ListInterventionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    RouterModule,
    NgbModalModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
