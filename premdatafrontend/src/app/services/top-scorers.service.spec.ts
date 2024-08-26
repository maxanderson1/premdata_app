import { TestBed } from '@angular/core/testing';

import { TopScorersService } from './top-scorers.service';

describe('TopScorersService', () => {
  let service: TopScorersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TopScorersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
