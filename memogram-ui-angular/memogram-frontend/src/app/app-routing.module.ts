import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DeadlineListComponent} from './ui/deadline/deadline-list/deadline-list.component';
import {MotiveListComponent} from './ui/motive/motive-list/motive-list.component';

const routes: Routes = [
  {path: '', redirectTo: '/deadlines', pathMatch: 'full'}, // TODO: main page
  {path: 'deadlines', component: DeadlineListComponent},
  {path: 'motives', component: MotiveListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
