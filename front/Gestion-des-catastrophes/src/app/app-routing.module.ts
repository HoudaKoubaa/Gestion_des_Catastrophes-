import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';

const routes: Routes = [
  {path: 'home',  component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path:'sidebar',component:SidebarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
