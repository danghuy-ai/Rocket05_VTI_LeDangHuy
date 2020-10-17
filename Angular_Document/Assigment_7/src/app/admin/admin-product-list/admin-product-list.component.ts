import { DecimalPipe } from '@angular/common';
import { Component, OnInit, PipeTransform } from '@angular/core'; 
import { FormControl } from '@angular/forms';
import { Observable, Subject } from 'rxjs';
import { debounceTime, map, startWith } from 'rxjs/operators';
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
//`${id}`
function search(text: string, pipe: PipeTransform, products): Product[] {
  return products.filter(product => {
    const term = text.toLowerCase();
    return product.name.toLowerCase().includes(term)
        || pipe.transform(product.price).includes(term)
        || pipe.transform(product.quantity).includes(term);
  });
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

  products$: Observable<Product[]>;
  filter = new FormControl('');

  products;
  productShow;
  page: number = 1;
  pageSize: number = 6;
  pageNum: number;
  pageNumArray;

  productModal: Product;
  showModal: boolean = false;

  constructor(private appService: AdminService, private pipe: DecimalPipe) {
    
  }

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
      this.search();
    })
    .catch(error => {
      //TODO
      console.log(error)
    })
  }

  search(){
    console.log("Here")
    this.products$ = this.filter.valueChanges.pipe(
      startWith(''),
      
      map(text => search(text, this.pipe, this.products))
    );
    this.products$.subscribe(result => {this.getPageNum(result.length), console.log("RUN: ",result)});
  }

  getPageNum(num: number){
    this.pageNum = Math.floor(num / this.pageSize);
    if(num % this.pageSize != 0)
      this.pageNum++;
    this.page = 1;
    this.pageNumArray = Array(this.pageNum).fill(4);
    this.products$.subscribe(result => {this.productShow = result.slice(0, this.pageSize)});
  }

  nextPage(){
    console.log(typeof(this.filter.value))
    this.page++;
    let index = (this.page - 1)*this.pageSize;
    this.products$.subscribe(result => {console.log("RUN2: ",result)});
    this.products$.subscribe(result => {console.log("RUN3: ",result); this.productShow =  result.slice(index, index+this.pageSize)});
  }

  previousPage(){
    this.page--;
    let index = (this.page - 1)*this.pageSize;
    this.products$.subscribe(result => {this.productShow =  result.slice(index, index+this.pageSize)});
  }

  firstPage(){
    this.page = 1;
    let index = (this.page - 1)*this.pageSize;
    this.products$.subscribe(result => {this.productShow =  result.slice(index, index+this.pageSize)});
  }

  lastPage(){
    this.page = this.pageNum;
    let index = (this.page - 1)*this.pageSize;
    this.products$.subscribe(result => {this.productShow =  result.slice(index, index+this.pageSize)});
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