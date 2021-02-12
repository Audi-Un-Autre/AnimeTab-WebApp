import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SplashComponent } from './splash/splash.component';
import { UserComponent } from './user/user.component';
import { EntryListComponent } from './entry-list/entry-list.component';
import { RegistrationComponent } from './registration/registration.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: UserComponent},
  {path: 'splash', component: SplashComponent},
  {path: 'entry-list', component: EntryListComponent},
  {path: 'new-user', component: RegistrationComponent},
  {path: 'welcome', component:WelcomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
