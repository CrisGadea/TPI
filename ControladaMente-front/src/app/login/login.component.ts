import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private service: LoginService) { }

  login(){
    let data = {
      email: 'admin2',
      password: 'admin'
    }
    this.service.login(data).subscribe((response)=>{
      console.log(response);
    },(error)=>{
      console.log(error);
    });
  }


  }
