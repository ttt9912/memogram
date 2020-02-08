import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TaskListComponent} from './ui/task/task-list/task-list.component';

const routes: Routes = [
  {path: '', redirectTo: '/tasks', pathMatch: 'full'}, // TODO: main page
  {path: 'tasks', component: TaskListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
