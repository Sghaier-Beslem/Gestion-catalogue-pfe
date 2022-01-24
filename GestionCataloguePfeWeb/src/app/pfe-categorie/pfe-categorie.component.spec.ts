import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PfeCategorieComponent } from './pfe-categorie.component';

describe('PfeCategorieComponent', () => {
  let component: PfeCategorieComponent;
  let fixture: ComponentFixture<PfeCategorieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PfeCategorieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PfeCategorieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
