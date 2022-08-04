import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { SignInComponent } from './components/sign-in/sign-in.component';

const routes: Routes = [
  {path: 'home',  component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'signin',  component: SignInComponent},
  {path:'sidebar',component:SidebarComponent},
  {path:'footer',component:FooterComponent},
  {path:'404',component:NotFoundComponent},
  {path:'notfound',component:NotFoundComponent},
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
