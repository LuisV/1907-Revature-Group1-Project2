import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GladiatorSelectComponent } from './gladiator-select.component';

describe('GladiatorSelectComponent', () => {
  let component: GladiatorSelectComponent;
  let fixture: ComponentFixture<GladiatorSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GladiatorSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GladiatorSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
