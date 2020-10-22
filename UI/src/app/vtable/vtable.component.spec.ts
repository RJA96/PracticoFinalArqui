import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VtableComponent } from './vtable.component';

describe('VtableComponent', () => {
  let component: VtableComponent;
  let fixture: ComponentFixture<VtableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VtableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
