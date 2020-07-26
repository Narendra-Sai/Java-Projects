import { Component, OnInit } from '@angular/core';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie.model';
import { ActivatedRoute, NavigationEnd} from '@angular/router';
import { UserPayload } from '../models/userPayload.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.scss']
})
export class MovieDetailComponent implements OnInit {
  movie: Movie = null;
  error: string = null;
  userPayload: UserPayload = null;

  constructor(
    private movieService: MovieService,
    private activatedRoute: ActivatedRoute, public router: Router) {}

  ngOnInit() {
    const { id } = this.activatedRoute.snapshot.params;
    this.getMovie(id);
  }

  getMovie(id: number) {
    if (sessionStorage.getItem('user') == null) {
      this.router.navigate(['/login']);
    }
    this.userPayload = new UserPayload(id, sessionStorage.getItem('user'), 'MovieById');
    this.movieService.getMovieById(this.userPayload)
      .subscribe(
        data => this.movie = data,
        err => this.error = err
      );
  }
}


