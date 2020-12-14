import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module.';
import {UserDetailComponent} from './user-detail.component';
import {UserService} from './UserService';
import {DetailComponent} from './Detail.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    UserDetailComponent,
    DetailComponent
  ],
  providers: [ UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
