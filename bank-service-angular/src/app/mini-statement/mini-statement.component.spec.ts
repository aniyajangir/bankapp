import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiniStatementComponent } from './mini-statement.component';

describe('MiniStatementComponent', () => {
  let component: MiniStatementComponent;
  let fixture: ComponentFixture<MiniStatementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiniStatementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MiniStatementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });
});
