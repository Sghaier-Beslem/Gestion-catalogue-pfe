import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PfeListComponent } from './pfe-list.component';

describe('PfeListComponent', () => {
  let component: PfeListComponent;
  let fixture: ComponentFixture<PfeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PfeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PfeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
