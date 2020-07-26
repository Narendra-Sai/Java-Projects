import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FiltermoviesService {
  constructor() { }

  filterMovies(filter: string, movies: any) {
    if (!filter || filter === 'all') {
      return movies;
    }
    return movies.filter(c => c.genres.includes(filter));
  }
}
