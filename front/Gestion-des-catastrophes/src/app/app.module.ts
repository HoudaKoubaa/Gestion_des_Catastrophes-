import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { BodyComponent } from './components/shared/body/body.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ListReportingComponent } from './components/reporting/list-reporting/list-reporting.component';
import { ListProgrammeComponent } from './components/programme/list-programme/list-programme.component';
import { ListInterventionComponent } from './components/intervention/list-intervention/list-intervention.component';
import { TopbarComponent } from './components/shared/topbar/topbar.component';
import { LoginComponent } from './components/login/login.component';
import {WeatherComponent} from "./components/weather/weather.component";
import { ListAlertComponent } from './components/Alert/list-alert/list-alert.component';
import { AddAlertComponent } from './components/Alert/add-alert/add-alert.component';
import {RouterModule} from "@angular/router";


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
    WeatherComponent,
    ListAlertComponent,
    AddAlertComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
