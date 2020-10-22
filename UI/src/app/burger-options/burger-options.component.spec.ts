import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BurgerOptionsComponent } from './burger-options.component';

describe('BurgerOptionsComponent', () => {
  let component: BurgerOptionsComponent;
  let fixture: ComponentFixture<BurgerOptionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BurgerOptionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BurgerOptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
