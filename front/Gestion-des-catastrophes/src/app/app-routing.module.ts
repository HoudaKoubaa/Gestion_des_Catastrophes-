import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { SignComponent } from './components/sign/sign.component';

const routes: Routes = [
  {path: 'home',  component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'login',  component: LoginComponent},
  {path: 'signup',  component: SignComponent},
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
