import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/admin/admin.service';

@Component({
  selector: 'app-pages-product-detail',
  templateUrl: './pages-product-detail.component.html',
  styleUrls: ['./pages-product-detail.component.scss']
})
export class PagesProductDetailComponent implements OnInit {

  id: string;
  product: any;

  constructor(
    private route: ActivatedRoute,
    private appService: AdminService
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.getItemByID(this.id);
  }

  getItemByID(id) {
    this.isProductExist(id);
  }

  isProductExist(id){
    this.appService.getProductsByID(id).then(response => {
      this.product = response;
    })
    .catch(error => {
      //TODO
    })
  }

}
