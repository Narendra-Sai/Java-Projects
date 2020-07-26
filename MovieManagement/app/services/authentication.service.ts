import { Injectable } from '@angular/core';
import { registrationEndpoint, loginEndpoint} from '../constants/constants';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError  } from "rxjs/index";
import { retry, catchError, tap} from 'rxjs/operators';

import { LoginModel } from '../models/login.model';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  authenticate(loginPayload): Observable<any> {
    return this.httpClient.post<LoginModel>(loginEndpoint, loginPayload)
      .pipe(
        tap(_ => console.log('fetched movies list')),
        catchError(this.handleError)
      );
  }

  registerUser(registrationPayload) {
    return this.httpClient.post(registrationEndpoint, registrationPayload)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = 'client Error: ${error.error.message}';
    } else {
      // server-side error
      errorMessage = 'server Error Code: ${error.status}\nMessage: ${error.message}';
    }
    console.log(errorMessage);
    
    return throwError(errorMessage);
  }
  logout() {
    sessionStorage.clear();
  }

  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem('user');
    if (user == null)
      return false;
    else
      return true;
  }

  isAdminUser(): boolean {
    let admin = sessionStorage.getItem('role');
    if (admin =='ADMIN')
      return true;
    else
      return false;
  }
}
