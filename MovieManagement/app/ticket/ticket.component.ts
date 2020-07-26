import { Component, OnInit } from '@angular/core';
import { Ticket } from '../models/ticket.model';
import { TheaterService } from '../services/theater.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.scss']
})
export class TicketComponent implements OnInit {
  ticket: Ticket = null;
  error: string = null;
  payload: Ticket;
  constructor(private theaterService: TheaterService,
    private activatedRoute: ActivatedRoute, public router: Router) { }

  ngOnInit() {
    
    const { id, showTime } = this.activatedRoute.snapshot.params;
    this.payload = new Ticket(id, showTime, sessionStorage.getItem('user'));
    this.theaterService.getTicket(this.payload)
      .subscribe(
        (data) => {
          this.ticket = data;
          err => this.error = err
        });

  }

}
