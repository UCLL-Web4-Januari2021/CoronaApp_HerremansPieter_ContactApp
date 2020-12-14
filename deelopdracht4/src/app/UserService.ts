import { Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';

import { User } from './User';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable()
export class UserService {
  private UsersUrl = 'http://localhost:8080/Controller?command=getpersons';
  private editUserUrl = 'http://localhost:8080/Controller?command=editperson';
  constructor(private http: HttpClient) {
  }
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.UsersUrl);
  }
  editUsers(user: User): Observable<User> {
      const url = this.editUserUrl;
      const json = JSON.stringify(user);
      return this.http.post<User>(url, json);
  }
}
