import { NgModule } from '@angular/core';
import { CommonModule, DecimalPipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { AdminProductListComponent } from './admin-product-list/admin-product-list.component';
import { AdminProductDetailComponent } from './admin-product-detail/admin-product-detail.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminProductCreateComponent } from './admin-product-create/admin-product-create.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [AdminComponent, AdminProductListComponent, AdminProductDetailComponent, AdminProductCreateComponent],
  imports: [
    HttpClientModule,
    CommonModule,
    MDBBootstrapModule.forRoot(),
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [DecimalPipe],
})
export class AdminModule { }
