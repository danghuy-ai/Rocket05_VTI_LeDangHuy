import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['./pages.component.scss']
})
export class PagesComponent implements OnInit {

  public hoverImg: string = '<img src="https://mdbootstrap.com/img/logo/mdb192x192.jpg"/>';

  constructor() { }

  ngOnInit(): void {
  }

}