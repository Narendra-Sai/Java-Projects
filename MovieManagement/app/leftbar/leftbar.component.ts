import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leftbar',
  templateUrl: './leftbar.component.html',
  styleUrls: ['./leftbar.component.scss']
})
export class LeftbarComponent implements OnInit {

  constructor(public router: Router) {
  }

  home() {
    this.router.navigate(['/home']);

  }
  ngOnInit(): void {
  }

}
