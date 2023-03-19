import { TestBed } from '@angular/core/testing';

import { ManagerserviceService } from './managerservice.service';

describe('ManagerserviceService', () => {
  let service: ManagerserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManagerserviceService);
  });

  xit('should be created', () => {
    expect(service).toBeTruthy();
  });
});
