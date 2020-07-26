import { Injectable } from '@angular/core';
import { allMoviesEndpoint, theaterToMovieLinkEndpoint, movieByIdEndpoint, allScreensEndpoint, allShowsEndpoint, createTheaterEndpoint, allTheatersEndpoint, createScreenEndpoint, createShowEndpoint,allTheaterByMovieIdEndpoint, createMovieEndpoint } from '../constants/constants';
import { Observable } from 'rxjs/internal/Observable';
import { of } from 'rxjs/internal/observable/of';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { Movie } from '../models/movie.model';
import { Theater } from '../models/theater.model';
import { Screen } from '../models/screen.model';
import { Show } from '../models/show.model';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(
    private http: HttpClient) { }

  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(allMoviesEndpoint)
      .pipe(
        tap(_ => console.log('fetched movies list')),
        catchError(this.handleError('getMovies', []))
      );
  }


  getTheaters(): Observable<Theater[]> {
    return this.http.get<Theater[]>(allTheatersEndpoint)
      .pipe(
        tap(_ => console.log('fetched theaters list')),
        catchError(this.handleError('getTheaters', []))
      );
  }
  getScreens(): Observable<Screen[]> {
    return this.http.get<Screen[]>(allScreensEndpoint)
      .pipe(
        tap(_ => console.log('fetched screens list')),
        catchError(this.handleError('getScreens', []))
      );
  }
  getShows(): Observable<Show[]> {
    return this.http.get<Show[]>(allShowsEndpoint)
      .pipe(
        tap(_ => console.log('fetched shows list')),
        catchError(this.handleError('getShows', []))
      );
  }
  
  linkTheaterToMovie(theaterToMovieLinkPayload): Observable<any> {
    return this.http.post<Boolean>(theaterToMovieLinkEndpoint, theaterToMovieLinkPayload)
      .pipe(
        tap(_ => console.log('linked theater to movie')),
        catchError(this.handleError)
      );
  }

  createMovie(createMoviePayload): Observable<any> {
    return this.http.post<Movie>(createMovieEndpoint, createMoviePayload)
      .pipe(
        tap(_ => console.log('fetched created movie')),
        catchError(this.handleError)
      );
  }

  createTheater(createTheaterPayload): Observable<any> {
    return this.http.post<Theater>(createTheaterEndpoint, createTheaterPayload)
      .pipe(
        tap(_ => console.log('fetched created theater')),
        catchError(this.handleError)
      );
  }


  createShow(createShowPayload): Observable<any> {
    return this.http.post<Show>(createShowEndpoint, createShowPayload)
      .pipe(
        tap(_ => console.log('fetched created show')),
        catchError(this.handleError)
      );
  }

  createScreen(createScreenPayload): Observable<any> {
    return this.http.post<Screen>(createScreenEndpoint, createScreenPayload)
      .pipe(
        tap(_ => console.log('fetched created screen')),
        catchError(this.handleError)
      );
  }

  getMovieById(userPayload): Observable<any> {
    return this.http.post<Movie>(movieByIdEndpoint, userPayload)
    .pipe(
      tap(_ => console.log('fetched movie' )),
      catchError(this.handleError<Movie>('getMovie'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log('${operation} failed: ${error.message}');

      return of(result as T);
    };
  }
}
