import {Component, OnInit} from '@angular/core';
import {ServiceCallTracker} from '../../../data/service-call-tracker';
import {TaskDTO} from '../../../generated/memogram-services';
import {TaskService} from '../../../business/task/task.service';
import {TaskDataService} from '../../../data/task/task-data.service';
import {OrderedTasks} from '../../../business/task/ordered-tasks';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  private orderedTasks: OrderedTasks;
  private tasksCall = new ServiceCallTracker<OrderedTasks>();

  constructor(private taskService: TaskService,
              private taskDataService: TaskDataService) {
  }

  ngOnInit() {
    this.loadAll();
  }

  loadAll() {
    this.tasksCall.execute(this.taskService.getTasks())
      .subscribe(orderedTasks => this.orderedTasks = orderedTasks);
  }

  delete(uuid: string): void {
    console.log(`delete with id=${uuid}`);
  }

  showDetail(uuid: string): void {
    console.log(`detail of uuid=${uuid}`);
  }

  getSeverity(task: TaskDTO) {
    if (!task.deadline) {
      return 'no-deadline';
    }

    if (this.getDaysUntil(task.deadline) < 0) {
      return 'overdue';
    }

    if (this.getDaysUntil(task.deadline) < 3) {
      return 'hot';
    }

    return 'cold';
  }

  private getDaysUntil(date: Date): number {
    const today = new Date();
    const diff = new Date(date).getTime() - today.getTime();
    return Math.ceil(diff / (1000 * 3600 * 24));
  }
}
