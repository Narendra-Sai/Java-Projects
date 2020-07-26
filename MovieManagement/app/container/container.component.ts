import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Location } from '@angular/common';
import { filter } from 'rxjs/operators';

import { Movie } from '../models/movie.model';
import { MovieService } from '../services/movie.service';
import { FiltermoviesService } from '../services/filtermovies.service';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss']
})
export class ContainerComponent implements OnInit {

  movies: Movie[] = null;
  movie: Movie = null;

  visibleMovies: Movie[] = null;
  searchText: any = '';
  sortBy: any = 'id';
  selectedGenre = 'all';

  constructor(
    private moviesService: MovieService,
    private filtermoviesService: FiltermoviesService,
    private router: Router,
    private location: Location) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
    });
  }

  ngOnInit() {
    this.moviesService.getMovies()
      .subscribe(movies => {
        this.movies = movies;
        this.applyFilter(this.selectedGenre);
      });
  }

  private applyFilter(filterBy: string) {
    
    this.visibleMovies = this.filtermoviesService.filterMovies(filterBy.toLowerCase(), this.movies);
  }

}
