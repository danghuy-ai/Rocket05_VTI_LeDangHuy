import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagesProductDetailComponent } from './pages-product-detail.component';

describe('PagesProductDetailComponent', () => {
  let component: PagesProductDetailComponent;
  let fixture: ComponentFixture<PagesProductDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagesProductDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PagesProductDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
