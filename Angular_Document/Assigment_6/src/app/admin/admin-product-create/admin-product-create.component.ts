import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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
  selector: 'app-admin-product-create',
  templateUrl: './admin-product-create.component.html',
  styleUrls: ['./admin-product-create.component.scss']
})
export class AdminProductCreateComponent implements OnInit {

  @Input() product: Product;
  @Output() isClose = new EventEmitter();

  @ViewChild('content', { static: false }) content: ElementRef;

  titleModal:string = '';

  numberPattern = /^[0-9]\d*$/i;

  productInfo = {
    id: '',
    name: '',
    price: '',
    quantity: ''
  }

  constructor(private modalService: NgbModal, private appService: AdminService) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.open(this.content, this.product)
    },200)
  }

  open(content, product) {
    if(product == null)
      this.titleModal = 'add';
    else{
      this.titleModal = 'edit';
      this.productInfo.name = product.name;
      this.productInfo.price = product.price;
      this.productInfo.quantity = product.quantity;
    }

    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      if (result == 'Save'){
        if(product == null){
          this.addProduct(this.productInfo);
        }
        else{
          let cf = confirm("Are you sure to update this product?");
          if (cf){
            this.save(product, this.productInfo);
          }
          else
            this.isClose.emit(1);
        }
      }
      else
        this.isClose.emit(1);
    }, (reason) => {
      this.isClose.emit(1);
    });
  }

  async addProduct(data){
    let name: string = data.name;
    let price:number = data.price;
    let quantity: number = data.quantity;

    let newProduct = new Product(null, name, price, quantity);

    this.appService.create(newProduct).then(res => {
      console.log('add product: ', res);
    })
    .catch(error => {
      //TODO
      console.log(error)
    })
    await this.wait(1000);
    this.isClose.emit(3);
  }

  async save(oldProduct: Product, data) {
    let product = new Product(oldProduct.id, data.name, data.price, data.quantity);
    let isCheck = await this.isProductExist(oldProduct.id);
    if(!isCheck){
      alert("This product is not exists in database!");
      this.isClose.emit(2);
      return;
    }

    this.appService.update(product).then(res => {
      console.log('update product: ', res)
    })
    .catch(error => {
      //TODO
      console.log(error)
    })
    await this.wait(1000);
    this.isClose.emit(4);
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
}
