import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocoFimComplexidadeComponent } from './bloco-fim-complexidade.component';

describe('BlocoFimComplexidadeComponent', () => {
  let component: BlocoFimComplexidadeComponent;
  let fixture: ComponentFixture<BlocoFimComplexidadeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlocoFimComplexidadeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlocoFimComplexidadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
