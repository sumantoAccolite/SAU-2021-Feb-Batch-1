import { TestBed } from '@angular/core/testing';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs'
import { ReviewService } from './review.service';

describe('ReviewService', () => {
  let service: ReviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
