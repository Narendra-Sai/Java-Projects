import { Component, OnInit } from '@angular/core';
import { Theater } from '../models/theater.model';
import { TheaterService } from '../services/theater.service';
import { ActivatedRoute } from '@angular/router';
import { UserPayload } from '../models/userPayload.model';

@Component({
  selector: 'app-theater',
  templateUrl: './theater.component.html',
  styleUrls: ['./theater.component.scss']
})
export class TheaterComponent implements OnInit {

  userPayload: UserPayload = null;
  theaters: Theater[] = null;
  error: string = null;

  constructor(private theaterService: TheaterService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    const { id } = this.activatedRoute.snapshot.params;
    this.getTheater(id);
  }

  getTheater(id: number) {
    this.userPayload = new UserPayload(id, sessionStorage.getItem('user'), 'TheaterById');

    this.theaterService.getTheaters(this.userPayload)
      .subscribe(
        data => this.theaters = data,
        err => this.error = err
      );
  }
}
