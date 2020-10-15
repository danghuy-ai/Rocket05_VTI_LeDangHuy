import { Component, OnInit } from '@angular/core'; 
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';
import { AdminService } from '../admin.service';

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

  products;
  productModal: Product;

  showModal: boolean = false;

  constructor(private appService: AdminService) { }

  ngOnInit(): void {
    this.getList();

    this._success.subscribe(message => this.successMessage = message);
    this._success.pipe(
      debounceTime(2000)
    ).subscribe(() => this.successMessage = '');
  }

  // Promise
  getList(){
    this.products = [];
    this.appService.get().then(response => {
      this.products = response;
    })
    .catch(error => {
      //TODO
      console.log(error)
    })
  }

  // Observable
  getProducts() {
    this.products = [];
    this.appService.getProducts().subscribe( res => {
      console.log("getProducts: ", res);
    });
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

  closeModal(value: number){
    if(value == 1)
      this.showModal = false;
    else if(value == 2){
      this.showModal = false;
      this.getList();
    }
    else if(value == 3){
      this.showModal = false;
      this.alertType = 'alert-success';
      this.showAlert('Create product is successful!')
      this.getList();
    }
    else if(value == 4){
      this.showModal = false;
      this.alertType = 'alert-success';
      this.showAlert('Update product is successful!')
      this.getList();
    }
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
    this.showModal = false;
  }

  async delete(index) {
    let isCheck = await this.isProductExist(this.products[index].id);
    if(!isCheck){
      alert("This product is not exists in database. Refresh website!");
      this.getList();
      return;
    }
    let cf = confirm(
      `Are you sure to delete the product?
      + Name:       ${this.products[index].name}
      + Price:         ${this.products[index].price}
      + Quantity:   ${this.products[index].quantity}`);
    if (cf){
      isCheck = await this.isProductExist(this.products[index].id);
      if(!isCheck){
        alert("This product is not exists in database. Refresh website!");
        this.getList();
        return;
      }
      this.deleteConfirmed(this.products[index].id)
    }
  }

  deleteConfirmed(index: number){
    this.appService.delete(index).then(res => {
      this.getList();
      this.alertType = 'alert-danger';
      this.showAlert('Delete product is successful!');
    })
    .catch(error => {
      //TODO
      console.log(error)
    })
  }

  async isProductExist(id: number){
    let isCheck = false;
    this.appService.getProductsByID(id).then(response => {
      isCheck = true;
    })
    .catch(error => {
      //TODO
    })
    await this.wait(1000);
    return isCheck;
  }

  wait(ms){
    return new Promise(r => setTimeout(r,ms))
  }

  public showAlert(message: string) {
    this._success.next(message);
  }
}