import {Component, OnInit} from '@angular/core';

import { User } from './User';
import { UserService} from './UserService';
import { timer} from 'rxjs';

@Component({
  selector: 'app-my-users',
  templateUrl: './users.component.html',
  styleUrls: [ './users.component.css']
})

export class UserDetailComponent implements OnInit {
  users: User[];
  currentuser: User;
  constructor(private userService: UserService) {
  }
  getUsers(): void {
    timer(0, 2500)
      .subscribe( () => {
        this.userService.getUsers()
          .subscribe(data => this.users = data);
      });
  }
  /*
  CurrentUser(User: user): void {
  }*/
  ngOnInit(): void {
    this.getUsers();
  }
}

/*import {Component, Input} from '@angular/core';
import {User} from './User';

@Component({
  selector: 'user-detail',
  template: `
  <div *ngIf="user">
    <h2>{{user.name}} deatils!</h2>
    <div><label>id:</label>{{user.id}}</div>
    <div>
      <label>name: </label>
      <input [(ngModel)]="user.name" placeholder="name"/>
    </div>
  </div>
  `
})
export class UserDetailComponent {
  @Input() user: User;
}*/
