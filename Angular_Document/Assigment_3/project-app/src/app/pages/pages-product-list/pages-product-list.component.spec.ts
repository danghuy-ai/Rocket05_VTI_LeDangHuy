import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PagesProductListComponent } from './pages-product-list.component';

describe('PagesProductListComponent', () => {
  let component: PagesProductListComponent;
  let fixture: ComponentFixture<PagesProductListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PagesProductListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PagesProductListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
