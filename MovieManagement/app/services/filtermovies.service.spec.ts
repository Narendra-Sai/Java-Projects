import { TestBed } from '@angular/core/testing';

import { FiltermoviesService } from './filtermovies.service';

describe('FiltermoviesService', () => {
  let service: FiltermoviesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FiltermoviesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
