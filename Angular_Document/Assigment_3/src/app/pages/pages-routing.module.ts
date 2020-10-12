import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PagesProductDetailComponent } from './pages-product-detail/pages-product-detail.component';
import { PagesProductListComponent } from './pages-product-list/pages-product-list.component';

import { PagesComponent } from './pages.component';

const routes: Routes = 
[
  { path: '', component: PagesComponent },
  { path: 'list', component: PagesProductListComponent },
  { path: 'detail', component: PagesProductDetailComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
