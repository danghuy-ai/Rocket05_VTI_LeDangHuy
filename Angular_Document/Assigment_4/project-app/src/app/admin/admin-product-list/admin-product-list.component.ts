import { Component, OnInit } from '@angular/core'; 
import { FormGroup, FormControl } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';  // ng add @ng-bootstrap/ng-bootstrap
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';

export class Product {
  id: number;
  name: string;
  price: number;
  quantity: number;

  constructor(id: number, name: string, price: number, quantity: number){
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
}

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.scss']
})

export class AdminProductListComponent implements OnInit {

  private _success = new Subject<string>();
  successMessage = '';
  alertType: string = 'alert-success';

  products: Array<Product> = [];
  productModal: Product;

  showModal: boolean = false;

  constructor() { }

  ngOnInit(): void {
    this._success.subscribe(message => this.successMessage = message);
    this._success.pipe(
      debounceTime(2000)
    ).subscribe(() => this.successMessage = '');
  }

  loadChildComponent(productIndex: Product){
    if(productIndex == null){
      this.productModal = null;
    }
    else{
      this.productModal = productIndex;
    }
    this.showModal = true;
  }

  closeModal(){
    this.showModal = false;
  }

  listChange(value: Product){
    if(value == null){
      this.showModal = false;
    }
    let index: number = this.products.findIndex(x => x.id == value.id)
    if(index >= 0){
      this.products[index].name = value.name;
      this.products[index].price = value.price;
      this.products[index].quantity = value.quantity;
      this.alertType = 'alert-success';
      this.showAlert('Update product is successful!')
    }
    else{
      this.products.push(value);
      this.alertType = 'alert-success';
      this.showAlert('Create new product is successful!')
    }
  }

  delete(index) {
    let cf = confirm(
      `Are you sure to delete the product?
      + Name:       ${this.products[index].name}
      + Price:         ${this.products[index].price}
      + Quantity:   ${this.products[index].quantity}`);
    if (cf){
      this.products.splice(index, 1);
      this.alertType = 'alert-danger';
      this.showAlert('Delete product is successful!')
    }
  }

  public showAlert(message: string) {
    this._success.next(message);
  }
}