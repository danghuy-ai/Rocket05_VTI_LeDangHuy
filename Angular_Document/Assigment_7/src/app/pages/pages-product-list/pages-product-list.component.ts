import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin/admin.service';

interface Product {
  id?: number;
  name: string;
  price: number;
  quantity: number;
}

@Component({
  selector: 'app-pages-product-list',
  templateUrl: './pages-product-list.component.html',
  styleUrls: ['./pages-product-list.component.scss']
})
export class PagesProductListComponent implements OnInit {

  products: any;
  linkBanTuan: string = 'https://pi-vn.herokuapp.com/nHmA&cUgC';

  constructor(private appService: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.getList();
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

  goToDetail(id){
    this.router.navigate(['detail/'+id]);
  }

}
