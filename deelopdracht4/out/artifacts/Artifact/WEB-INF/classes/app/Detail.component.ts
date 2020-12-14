import {Component, OnInit} from '@angular/core';

import {User} from './User';
import {UserService} from './UserService';
import { timer } from 'rxjs';

@Component({
  selector: 'app-my-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})

export class DetailComponent implements OnInit {
  users: User[];
  constructor(private userService: UserService) {
  }
  getUsers(): void {
    timer(0, 2500)
      .subscribe(() => {
        this.userService.getUsers()
          .subscribe(data => this.users = data);
      });
  }
  ngOnInit(): void {
    this.getUsers();
  }
}

