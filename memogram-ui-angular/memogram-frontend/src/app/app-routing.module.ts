import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TaskListComponent} from './ui/task/task-list/task-list.component';
import {TopicListComponent} from './ui/topic/topic-list/topic-list.component';
import {TopicDetailComponent} from './ui/topic/topic-detail/topic-detail.component';

const routes: Routes = [
  {path: '', redirectTo: '/app/tasks', pathMatch: 'full'}, // TODO: main page
  {path: 'app', redirectTo: '/app/tasks', pathMatch: 'full'},
  {path: 'app/tasks', component: TaskListComponent},
  {path: 'app/topics', component: TopicListComponent},
  {path: 'app/topics/:key', component: TopicDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
