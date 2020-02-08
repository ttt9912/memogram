import {Component, OnInit} from '@angular/core';
import {TaskService} from '../../../business/task/task.service';
import {ServiceCall} from '../../../data/service-call';
import {TaskDTO} from '../../../generated/memogram-services';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  private tasks: TaskDTO[];
  private tasksCall: ServiceCall<TaskDTO[]>;

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
    this.tasksCall = this.taskService.getDeadlines();
    this.tasksCall.observable.subscribe(
      res => this.tasks = res
    );
  }


  showDetail(uuid: string): void {
    console.log(`detail of uuid=${uuid}`);
  }

  delete(uuid: string): void {

  }
}
