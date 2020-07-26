import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl, NgForm } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { LoginModel } from '../models/login.model';
import { UserModel } from '../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

  errorMessage: string;
  autherized: boolean
  isAdmin: boolean
  loginFormGroup: FormGroup;
  loginPayload: LoginModel;
  user: UserModel;
  loginUser: string;
  loginPassword: string;
  

  constructor(formBuilder: FormBuilder, public authservice: AuthenticationService, public router: Router) {
  this.loginFormGroup = formBuilder.group({
      "user_id": new FormControl("user_id"),
      "user_pass": new FormControl("user_pass", Validators.compose([Validators.required,
      Validators.minLength(8)]))
    });

    this.errorMessage = "Please Confirm Credentials!!! ";
    this.autherized = false;
  }

  login() {
    this.loginUser = this.loginFormGroup.controls['user_id'].value,
    this.loginPassword = this.loginFormGroup.controls['user_pass'].value

    this.loginPayload = new LoginModel(this.loginUser, this.loginPassword);

    this.authservice.authenticate(this.loginPayload)
      .subscribe(
        (user) => {
          this.user = user;
          this.autherized = true;
          sessionStorage.setItem('user', this.user.userid);
          sessionStorage.setItem('role', this.user.role);
          if (this.user.role == 'ADMIN') {
            this.router.navigate(['/admin']);
          }
          if (this.user.role == 'USER') {
            this.router.navigate(['/home']);
          }
      });
  }

  logout() {
    this.authservice.logout();
    this.router.navigate(['/login']);
  }
  resetForm(form: NgForm) {
    form.resetForm();
  }

  ngOnInit(): void {
    this.autherized = this.authservice.isUserLoggedIn();
  }

}
