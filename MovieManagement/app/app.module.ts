import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';  
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSelectModule } from '@angular/material/select';

import { MatListModule, } from '@angular/material/list';
import { MatButtonModule, } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';


import { ContainerModule } from './container/container.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { routes } from './app-routing.module';
import { LeftbarComponent } from './leftbar/leftbar.component';
import { RightbarComponent } from './rightbar/rightbar.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ContainerComponent } from './container/container.component';
import { AdminComponent } from './admin/admin.component';


@NgModule({
  declarations: [
    AppComponent,
    LeftbarComponent,
    RightbarComponent,
    SearchComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    FooterComponent,
    ContainerComponent,
    AdminComponent
               
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ContainerModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatCardModule,
    MatSelectModule,
    MatToolbarModule,
    MatListModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatMenuModule,
     RouterModule.forRoot(routes, { useHash: true })

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
