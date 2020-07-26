import { Component, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl, NgForm } from '@angular/forms';
import { RegistrationModel } from '../models/registration.model';
import { AuthenticationService } from '../services/authentication.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit, OnChanges {
  registrationFormGroup: FormGroup;
  errorMessage: string;
  registered: boolean;
  userName: string;
  email: string;
  password: string;
  confirmPassword: string;

  registrationPayload: RegistrationModel;

  constructor(formBuilder: FormBuilder, public authservice: AuthenticationService, public router: Router) {
    this.registrationFormGroup = formBuilder.group({
      "FirstName": new FormControl("FirstName"),
      "LastName": new FormControl("LastName"),
      "Email": new FormControl("Email"),
      "Password": new FormControl("Password", Validators.compose([Validators.required,
      Validators.minLength(8)])),
      "ConfirmPassword": new FormControl("ConfirmPassword", Validators.compose([Validators.required,
      Validators.minLength(8)]))

    });
    this.errorMessage = "Confirm Inputs !!! ";
    this.registered = true;
  }
  ngOnChanges(changes: SimpleChanges): void {

    throw new Error("Method not implemented.");
  }
  registerUser() {

    this.registrationPayload = new RegistrationModel(
      this.registrationFormGroup.controls['FirstName'].value,
      this.registrationFormGroup.controls['LastName'].value,
      this.registrationFormGroup.controls['Email'].value,
      this.registrationFormGroup.controls['Password'].value,
      this.registrationFormGroup.controls['ConfirmPassword'].value);

    this.authservice.registerUser(this.registrationPayload)
      .subscribe(
        (data) => {
            this.router.navigate(['/login']);
        });
  }
  ngOnInit(): void {
  }

}
