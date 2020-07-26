import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { CommonModule } from '@angular/common';
import { ContainerComponent } from './container/container.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TheaterComponent } from './theater/theater.component';
import { TicketComponent } from './ticket/ticket.component';
import { ScreenDetailsComponent } from './screen-details/screen-details.component';
import { AdminComponent } from './admin/admin.component';


export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: ContainerComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegisterComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'ticket', component: TicketComponent },
  { path: 'theater', loadChildren: () => import('./theater/theater.module').then(t => t.TheaterModule) },
  { path: 'movie', loadChildren: () => import('./container/container.module').then(c => c.ContainerModule) },
  { path: 'screen', loadChildren: () => import('./screen-details/screen-details.module').then(sd => sd.ScreenDetailsModule) }

]; 

@NgModule({
  declarations: [
    MovieDetailComponent,
    TheaterComponent,
    ScreenDetailsComponent,
    TicketComponent
  
    
  ],
  imports: [CommonModule,
    RouterModule.forRoot(routes),
    RouterModule.forChild([
      {path: 'theater/:id', component: TheaterComponent},
      { path: 'movie/:id', component: MovieDetailComponent },
      { path: 'screen/:id', component: ScreenDetailsComponent },
      { path: 'ticket/:id/:showTime', component: TicketComponent }
    ]),
   
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
