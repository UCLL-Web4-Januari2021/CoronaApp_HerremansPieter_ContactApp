import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserDetailComponent } from './user-detail.component';
import { DetailComponent} from './Detail.component';

const routes: Routes = [
  { path: 'users', component: UserDetailComponent },
  { path: 'details', component: DetailComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
