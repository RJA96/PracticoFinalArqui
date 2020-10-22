import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MapMediumComponent } from './map-medium.component';

describe('MapMediumComponent', () => {
  let component: MapMediumComponent;
  let fixture: ComponentFixture<MapMediumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapMediumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapMediumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
