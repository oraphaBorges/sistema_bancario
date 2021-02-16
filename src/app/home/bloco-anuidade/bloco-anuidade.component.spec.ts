import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocoAnuidadeComponent } from './bloco-anuidade.component';

describe('BlocoAnuidadeComponent', () => {
  let component: BlocoAnuidadeComponent;
  let fixture: ComponentFixture<BlocoAnuidadeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlocoAnuidadeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlocoAnuidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
