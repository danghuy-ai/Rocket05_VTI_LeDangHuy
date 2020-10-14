import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-product-detail',
  templateUrl: './admin-product-detail.component.html',
  styleUrls: ['./admin-product-detail.component.scss']
})
export class AdminProductDetailComponent implements OnInit {

  @Input() item;

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => { 
      window.scrollTo(0, 0);
    });

    this.getItemByID();
  }

  getItemByID() {
    let id = 1;
    // call server get data
    this.item = {
      id: 1,
      name: "huy",
      age: 21
    }
  }
}
