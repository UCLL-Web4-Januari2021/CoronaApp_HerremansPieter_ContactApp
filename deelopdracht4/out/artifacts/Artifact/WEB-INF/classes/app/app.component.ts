import { Component} from '@angular/core';

@Component({
  selector: 'app-user',
  template: `<h1>{{title}}</h1>
  <nav>
    <a routerLink="/users">Users</a>
    <br>
    <a routerLink="/details">Details</a>
  </nav>
  <router-outlet></router-outlet>
  `
})

export class AppComponent {
  title = 'Users exercise';
}
