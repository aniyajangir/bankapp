import { TestBed } from '@angular/core/testing';

import { GlobalVariableChangeService } from './global-variable-change.service';

describe('GlobalVariableChangeService', () => {
  let service: GlobalVariableChangeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GlobalVariableChangeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
