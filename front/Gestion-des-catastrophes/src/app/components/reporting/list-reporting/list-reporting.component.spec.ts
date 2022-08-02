import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListReportingComponent } from './list-reporting.component';

describe('ListReportingComponent', () => {
  let component: ListReportingComponent;
  let fixture: ComponentFixture<ListReportingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListReportingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListReportingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
