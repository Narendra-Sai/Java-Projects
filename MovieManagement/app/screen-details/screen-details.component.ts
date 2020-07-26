import { Component, OnInit } from '@angular/core';
import { Screen } from '../models/screen.model';
import { Ticket } from '../models/ticket.model';
import { TheaterService } from '../services/theater.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { UserPayload } from '../models/userPayload.model';

@Component({
  selector: 'app-screen-details',
  templateUrl: './screen-details.component.html',
  styleUrls: ['./screen-details.component.scss']
})
export class ScreenDetailsComponent implements OnInit {
  userPayload: UserPayload = null;
  screens: Screen[] = null;
  error: string = null;
  screen: Screen = null;
  id: number = null;
  showTime: string = null;

  constructor(private theaterService: TheaterService,
    private activatedRoute: ActivatedRoute, public router: Router) { }

  ngOnInit() {
    const { id } = this.activatedRoute.snapshot.params;
    this.getAllScreens(id);
  }

  getAllScreens(id: number) {
    this.userPayload = new UserPayload(id, sessionStorage.getItem('user'), 'ScreenByTheaterId');
      this.theaterService.getAllScreens(this.userPayload)
      .subscribe(
        data => this.screens = data,
        err => this.error = err
    );
  }

  onSelect(show) {
    this.id = show.id;
    this.showTime = show.showTime;
  }
    
}
