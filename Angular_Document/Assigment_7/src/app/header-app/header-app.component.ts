import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-app',
  templateUrl: './header-app.component.html',
  styleUrls: ['./header-app.component.scss']
})

export class HeaderAppComponent implements OnInit {

  isAdmin: boolean = false;
  userName: string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    if("admin" == localStorage.getItem('username')){
      this.isAdmin = true;
      this.userName = localStorage.getItem('username');
    }
  }

  logout(){
    this.userName = '';
    this.isAdmin = false;
    localStorage.clear();
    this.router.navigate(['home']);
  }

}
