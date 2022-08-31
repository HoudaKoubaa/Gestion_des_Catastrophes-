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
import { ListReportingComponent } from './components/reporting/list-reporting/list-reporting.component';
import { ListProgrammeComponent } from './components/programme/list-programme/list-programme.component';
import { ListInterventionComponent } from './components/intervention/list-intervention/list-intervention.component';
import { TopbarComponent } from './components/shared/topbar/topbar.component';
import { LoginComponent } from './components/login/login.component';
import { SignComponent } from './components/sign/sign.component';
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
    ListInterventionComponent,
    TopbarComponent,
    LoginComponent,
    SignComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
