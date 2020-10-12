import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PagesRoutingModule } from './pages-routing.module';
import { PagesComponent } from './pages.component';
import { PagesProductListComponent } from './pages-product-list/pages-product-list.component';
import { PagesProductDetailComponent } from './pages-product-detail/pages-product-detail.component';


@NgModule({
  declarations: [PagesComponent, PagesProductListComponent, PagesProductDetailComponent],
  imports: [
    CommonModule,
    PagesRoutingModule
  ]
})
export class PagesModule { }
