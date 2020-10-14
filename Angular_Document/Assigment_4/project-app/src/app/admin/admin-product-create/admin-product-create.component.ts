import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

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
  @Output() newProduct = new EventEmitter<Product>();

  @ViewChild('content', { static: false }) content: ElementRef;

  titleModal:string = '';

  numberPattern = /^[0-9]\d*$/i;

  productInfo = {
    id: '',
    name: '',
    price: '',
    quantity: ''
  }

  constructor(private modalService: NgbModal) { }

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
        }
      }
      this.isClose.emit(false);
    }, (reason) => {
      this.isClose.emit(false);
    });
  }

  addProduct(data){
    let id:number = data.id;
    let name: string = data.name;
    let price:number = data.price;
    let quantity: number = data.quantity;

    let product = new Product(id, name, price, quantity);
    this.newProduct.emit(product);
  }

  save(oldProduct: Product, data) {
    let product = new Product(oldProduct.id, data.name, data.price, data.quantity);
    this.newProduct.emit(product);
  }
}
