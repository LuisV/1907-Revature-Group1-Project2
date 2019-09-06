import { TestBed } from '@angular/core/testing';

import { PagestateService } from './pagestate.service';

describe('PagestateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PagestateService = TestBed.get(PagestateService);
    expect(service).toBeTruthy();
  });
});
