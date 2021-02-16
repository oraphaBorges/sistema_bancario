import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocoCadastroLoginComponent } from './bloco-cadastro-login.component';

describe('BlocoCadastroLoginComponent', () => {
  let component: BlocoCadastroLoginComponent;
  let fixture: ComponentFixture<BlocoCadastroLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlocoCadastroLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlocoCadastroLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
