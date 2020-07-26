import { Injectable } from '@angular/core';
import { of } from 'rxjs/internal/observable/of';
import { allTheaterByMovieIdEndpoint, allScreenEndpoint, ticketEndpoint } from '../constants/constants';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap, retry } from 'rxjs/operators';

import { Theater } from '../models/theater.model';
import { Screen } from '../models/screen.model';
import { Ticket } from '../models/ticket.model';

@Injectable({
  providedIn: 'root'
})
export class TheaterService {

  constructor(private http: HttpClient) { }

  
  getTheaters(userPayload): Observable<any> {
    return this.http.post<Theater[]>(allTheaterByMovieIdEndpoint, userPayload)
      .pipe(
        tap(_ => console.log('fetched theater list')),
        catchError(this.handleError('getTheaters', []))
      );
  }

  getAllScreens(userPayload): Observable<any> {
    return this.http.post<Screen[]>(allScreenEndpoint, userPayload)
      .pipe(
        tap(_ => console.log('fetched Screen list'),
          catchError(this.handleError('getAllScreens '))
        ));
  }

  getTicket(showPayload): Observable<any>{
    return this.http.post<Ticket>(ticketEndpoint, showPayload)
      .pipe(
        tap(_ => console.log('fetched Ticket')),
        catchError(this.handleError)
      );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log('${operation} failed: ${error.message}');
      return of(result as T);
    };
  }
}
