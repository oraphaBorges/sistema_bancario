import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocoCelularesComponent } from './bloco-celulares.component';

describe('BlocoCelularesComponent', () => {
  let component: BlocoCelularesComponent;
  let fixture: ComponentFixture<BlocoCelularesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlocoCelularesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlocoCelularesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
