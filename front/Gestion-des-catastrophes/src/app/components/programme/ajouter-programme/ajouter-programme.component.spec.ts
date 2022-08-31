import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterProgrammeComponent } from './ajouter-programme.component';

describe('AjouterProgrammeComponent', () => {
  let component: AjouterProgrammeComponent;
  let fixture: ComponentFixture<AjouterProgrammeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjouterProgrammeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterProgrammeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
