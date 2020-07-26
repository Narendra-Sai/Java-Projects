import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-rightbar',
  templateUrl: './rightbar.component.html',
  styleUrls: ['./rightbar.component.scss']
})
export class RightbarComponent implements OnInit {

  constructor(public authservice: AuthenticationService, public router: Router) {
  }

  login() {
    this.router.navigate(['/login']);
  }

  registration() {
    this.router.navigate(['/registration']);  
  }

  logout() {
    this.authservice.logout();
    this.router.navigate(['/login']);
  }

  admin() {
    this.router.navigate(['/admin']);
  }
  ngOnInit(): void {
  }

}
