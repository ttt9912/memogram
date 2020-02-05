import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DeadlineListComponent} from './ui/deadline/deadline-list/deadline-list.component';

const routes: Routes = [
  {path: '', redirectTo: '/deadlines', pathMatch: 'full'}, // TODO: main page
  {path: 'deadlines', component: DeadlineListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
