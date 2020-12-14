import {Component, Input, OnInit} from '@angular/core';

import { User } from './User';
import { UserService} from './UserService';
import { timer} from 'rxjs';

@Component({
  selector: 'app-my-users',
  templateUrl: './users.component.html',
  styleUrls: [ './users.component.css']
})

export class UserDetailComponent implements OnInit {
  constructor(private userService: UserService) {
  }
  selectedUser: User;
  users: User[];
  @Input() user: User;
  getUsers(): void {
    timer(0, 2500)
      .subscribe( () => {
        this.userService.getUsers()
          .subscribe(data => this.users = data);
      });
  }
  onSelect(user): void {
    this.selectedUser = user;
  }
  editUser(): void{
    this.userService.editUsers(this.selectedUser)
      .subscribe(data => this.selectedUser = data);
  }
  ngOnInit(): void {
    this.getUsers();
  }
}
