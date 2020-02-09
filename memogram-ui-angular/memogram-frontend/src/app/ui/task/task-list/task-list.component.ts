import {Component, OnInit} from '@angular/core';
import {TaskService} from '../../../business/task/task.service';
import {ServiceCallTracker} from '../../../data/service-call-tracker';
import {TaskDTO} from '../../../generated/memogram-services';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  private tasks: TaskDTO[];
  private tasksCall = new ServiceCallTracker<TaskDTO[]>();

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
    this.loadAll();
  }

  loadAll() {
    this.tasksCall.execute(this.taskService.getTasks())
      .subscribe(tasks => this.tasks = tasks);
  }

  delete(uuid: string): void {
    console.log(`delete with id=${uuid}`);
  }

  showDetail(uuid: string): void {
    console.log(`detail of uuid=${uuid}`);
  }
}
