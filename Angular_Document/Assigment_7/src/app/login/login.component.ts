import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private _success = new Subject<string>();
  successMessage = '';

  constructor(private router: Router) { }

  login = new FormGroup ({
    username: new FormControl('',[Validators.required]),
    password: new FormControl('',[Validators.required])
  })

  ngOnInit(): void {
    this._success.subscribe(message => this.successMessage = message);
    this._success.pipe(
      debounceTime(5000)
    ).subscribe(() => this.successMessage = '');
  }

  submitLogin(){
    if("" == this.login.value.username && "" == this.login.value.password){
      this.showAlert('Enter username and password in textbox!')
      return;
    }
    if("" == this.login.value.username){
      this.showAlert('Enter username in textbox!')
      return;
    }
    if("" == this.login.value.password){
      this.showAlert('Enter password in textbox!')
      return;
    }
    if("admin" == this.login.value.username && "admin" == this.login.value.password){
      localStorage.setItem("username", this.login.value.username)
      this.router.navigate(['admin']);
    }
    else{
      this.showAlert('Username or password entered incorrectly. Retype!')
    }
      
  }

  public showAlert(message: string) {
    this._success.next(message);
  }
}
