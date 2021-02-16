import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocoFooterComponent } from './bloco-footer.component';

describe('BlocoFooterComponent', () => {
  let component: BlocoFooterComponent;
  let fixture: ComponentFixture<BlocoFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlocoFooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlocoFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
