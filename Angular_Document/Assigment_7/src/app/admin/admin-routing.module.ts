import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminProductDetailComponent } from './admin-product-detail/admin-product-detail.component';
import { AdminProductListComponent } from './admin-product-list/admin-product-list.component';
import { AdminComponent } from './admin.component';

const routes: Routes = 
[
  { path: '', component: AdminComponent },
  { path: 'list', component: AdminProductListComponent },
  { path: 'detail/:id', component: AdminProductDetailComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
