import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardEstadisticasComponent } from './card-estadisticas.component';

describe('CardEstadisticasComponent', () => {
  let component: CardEstadisticasComponent;
  let fixture: ComponentFixture<CardEstadisticasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardEstadisticasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardEstadisticasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
