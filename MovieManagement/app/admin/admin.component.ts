import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Movie } from '../models/movie.model';
import { Theater } from '../models/theater.model';
import { Screen } from '../models/screen.model';
import { Show } from '../models/show.model';
import { TheaterToMovieLink } from '../models/theaterToMovieLink.model';

import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  theateridTolink: number;
  showidTolink: number;
  screenidTolink: number;
  theaters: Theater[] = null;
  screens: Screen[] = null;
  shows: Show[] = null;
  movies: Movie[] = null;

  movieFormGroup: FormGroup;
  theaterFormGroup: FormGroup;
  showFormGroup: FormGroup;
  screenFormGroup: FormGroup;
  theaterLinkingFormGroup: FormGroup;

  createScreenPayload: Screen;
  createShowPayload: Show;
  createMoviePayload: Movie;
  createTheaterPayload: Theater;
  theaterToMovieLinkPayload: TheaterToMovieLink;
  isLinked: Boolean;

  isAdd = true;
  isUpdate = true;
  isDelete = true;
  isLink = true;
  isMovieCreation = true;
  isTheaterCreation = true;
  isScreenCreation = true;
  isShowCreation = true;
  isTheaterLinking = true;

  constructor(formBuilder: FormBuilder, public movieservice: MovieService, public router: Router) {

    this.theaterFormGroup = formBuilder.group({
      "TheaterName": new FormControl("TheaterName"),
      "TheaterAddress": new FormControl("TheaterAddress"),
      "TheaterCiti": new FormControl("TheaterCiti"),
      "TheaterRating": new FormControl("TheaterRating"),
      "TheaterImage": new FormControl("TheaterImage")
    });

    this.movieFormGroup = formBuilder.group({
      "MovieName": new FormControl("movie_Name"),
      "MovieDescription": new FormControl("MovieDescription"),
      "MovieLength": new FormControl("MovieLength"),
      "MovieRating": new FormControl("MovieRating"),
      "MovieImage": new FormControl("MovieImage"),
      "MovieCover": new FormControl("MovieCover")
    });

    this.screenFormGroup = formBuilder.group({
      "ScreenName": new FormControl("ScreenName"),
      "Capacity": new FormControl("Capacity"),
      "Availability": new FormControl("Availability")
    });

    this.showFormGroup = formBuilder.group({
      "Price": new FormControl("Price"),
      "StartTime": new FormControl("StartTime"),
      "EndTime": new FormControl("EndTime")
    });
  }




  onTheaterLinking() {
    this.isTheaterLinking = !this.isTheaterLinking;
    this.isTheaterCreation = true;
    this.isMovieCreation = true;
    this.isScreenCreation = true;
    this.isShowCreation = true;
    this.theaterToMovieLinkPayload = new TheaterToMovieLink();

    /*post call to fatch all theaters */

    this.movieservice.getTheaters()
      .subscribe(theaters => {
        this.theaters = theaters;
      });

  }
  /*submit final linking */
  linkTheaterSubmit() {
    this.movieservice.linkTheaterToMovie(this.theaterToMovieLinkPayload)
      .subscribe(isLinked => {
        this.isLinked = isLinked;
      });
    console.log('Is link created ' + this.isLinked);
  }
  onLinkTheaterChange(theater) {
    this.movieservice.getScreens()
      .subscribe(screens => {
        this.screens = screens;
      });
    this.theaterToMovieLinkPayload.theaterid = theater.value;
    console.log('selected theater  : '+ theater.value);
  }

  onLinkShowChange(show) {
    this.movieservice.getMovies()
      .subscribe(movies => {
        this.movies = movies;
      });
    this.theaterToMovieLinkPayload.showid = show.value;
    console.log('selected show  : ' + show.value);
  }
  onLinkScreenChange(screen) {
    this.movieservice.getShows()
      .subscribe(shows => {
        this.shows = shows;
      });
    this.theaterToMovieLinkPayload.screenid = screen.value;
    console.log('selected screen  : ' + screen.value);
  }

  onLinkMovieChange(movie) {
    this.theaterToMovieLinkPayload.movieid = movie.value;
  }

  createNewShow() {
    this.createShowPayload = new Show(
      this.showFormGroup.controls['StartTime'].value,
      this.showFormGroup.controls['EndTime'].value,
      this.showFormGroup.controls['Price'].value);

    this.movieservice.createShow(this.createShowPayload)
      .subscribe(
        (show) => {          
        });
  }

  createNewScreen() {
    this.createScreenPayload = new Screen(
      this.screenFormGroup.controls['ScreenName'].value,
      this.screenFormGroup.controls['Capacity'].value,
      this.screenFormGroup.controls['Availability'].value);

    this.movieservice.createScreen(this.createScreenPayload)
      .subscribe(
        (screen) => {
          // this.router.navigate(['/login']);
        });
  }

  createNewTheater() {
    this.createTheaterPayload = new Theater(
      this.theaterFormGroup.controls['TheaterName'].value,
      this.theaterFormGroup.controls['TheaterAddress'].value,
      this.theaterFormGroup.controls['TheaterCiti'].value,
      this.theaterFormGroup.controls['TheaterRating'].value,
      this.theaterFormGroup.controls['TheaterImage'].value);
      
    this.movieservice.createTheater(this.createTheaterPayload)
      .subscribe(
        (theater) => {
          // this.router.navigate(['/login']);
        });
  }

  createNewMovie() {
    this.createMoviePayload = new Movie(
      this.movieFormGroup.controls['MovieName'].value,
      this.movieFormGroup.controls['MovieDescription'].value,
      this.movieFormGroup.controls['MovieLength'].value,
      this.movieFormGroup.controls['MovieRating'].value,
      this.movieFormGroup.controls['MovieImage'].value,
      this.movieFormGroup.controls['MovieCover'].value);

    this.movieservice.createMovie(this.createMoviePayload)
      .subscribe(
        (movie) => {
          // this.router.navigate(['/login']);
        });
  }

  onCreate() {
    this.isAdd = !this.isAdd;
    this.isUpdate = true;
    this.isDelete = true;
    this.isLink = true;
    this.isTheaterLinking = true;
  }

  onUpdate() {
    this.isUpdate = !this.isUpdate;
    this.isAdd = true;
    this.isDelete = true;
    this.isLink = true;
  }
  onDelete() {
    this.isDelete = !this.isDelete;
    this.isAdd = true;
    this.isUpdate = true;
    this.isLink = true;
  }
  onLink() {
    this.isLink = !this.isLink;
    this.isAdd = true;
    this.isUpdate = true;
    this.isDelete = true;
    this.isMovieCreation = true;
    this.isTheaterCreation = true;
    this.isScreenCreation = true;
    this.isShowCreation = true;
  }

  onMovieCreate() {
    this.isMovieCreation = !this.isMovieCreation;
    this.isTheaterCreation = true;
    this.isScreenCreation = true;
    this.isShowCreation = true;
  }

  onTheaterCreate() {
    this.isTheaterCreation = !this.isTheaterCreation;
    this.isMovieCreation = true;
    this.isScreenCreation = true;
    this.isShowCreation = true;
  }
  onScreenCreate() {
    this.isScreenCreation = !this.isScreenCreation;
    this.isTheaterCreation = true;
    this.isMovieCreation = true;
    this.isShowCreation = true;
  }
  onShowCreate() {
    this.isShowCreation = !this.isShowCreation;
    this.isTheaterCreation = true;
    this.isMovieCreation = true;
    this.isScreenCreation = true;
  }

  ngOnInit(): void {
  }

}
