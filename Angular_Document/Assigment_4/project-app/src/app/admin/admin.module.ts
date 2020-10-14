import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { AdminProductListComponent } from './admin-product-list/admin-product-list.component';
import { AdminProductDetailComponent } from './admin-product-detail/admin-product-detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminProductCreateComponent } from './admin-product-create/admin-product-create.component';



@NgModule({
  declarations: [AdminComponent, AdminProductListComponent, AdminProductDetailComponent, AdminProductCreateComponent],
  imports: [
    HttpClientModule,
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    
  ]
})
export class AdminModule { }
