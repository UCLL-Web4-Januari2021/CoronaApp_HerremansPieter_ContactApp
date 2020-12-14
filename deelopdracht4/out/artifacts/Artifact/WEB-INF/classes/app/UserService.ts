import { Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from './User';
import {Observable} from 'rxjs';

@Injectable()
export class UserService {
  private UsersUrl = 'http://localhost:8080/Controller';
  constructor(private http: HttpClient) {
  }
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.UsersUrl);
  }
}
