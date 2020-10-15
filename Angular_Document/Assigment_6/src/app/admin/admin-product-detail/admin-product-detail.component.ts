import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-product-detail',
  templateUrl: './admin-product-detail.component.html',
  styleUrls: ['./admin-product-detail.component.scss']
})
export class AdminProductDetailComponent implements OnInit {

  item: any;
  id: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private appService: AdminService
  ) { }

   ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.getItemByID(this.id);

    // this.route.params.subscribe(params => { 
    //   window.scrollTo(0, 0);
    //   console.log("para: ",params);
    //   console.log("router: ",this.router.url)
    // });
  }

  getItemByID(id) {
    this.isProductExist(id);
  }

  isProductExist(id){
    this.appService.getProductsByID(id).then(response => {
      this.item = response;
    })
    .catch(error => {
      //TODO
    })
  }
}
