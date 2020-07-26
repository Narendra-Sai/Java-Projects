export class RegistrationModel {

  firstName: string;
  lastName: string;
  email: string;
  password: string;
  cnfPassword: string;

  constructor( firstName: string, lastName: string, email: string, password: string, cnfPassword: string) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.cnfPassword = cnfPassword;
    
  }

}
