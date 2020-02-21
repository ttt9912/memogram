import {Component, OnInit} from '@angular/core';
import {ServiceCallTracker} from '../../../data/service-call-tracker';
import {TaskDTO} from '../../../generated/memogram-services';
import {TaskService} from '../../../business/task/task.service';
import {OrderedTasks} from '../../../business/task/ordered-tasks';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  orderedTasks: OrderedTasks;

  input: string;

  private getTasksCall = new ServiceCallTracker<OrderedTasks>();
  private addTaskCall = new ServiceCallTracker<any>();
  private deleteTaskCall = new ServiceCallTracker<any>();

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
    this.loadAll();
  }

  loadAll() {
    this.getTasksCall.execute(this.taskService.getTasks())
      .subscribe(orderedTasks => this.orderedTasks = orderedTasks);
  }

  createTask($event: string) {
    this.addTaskCall.execute(this.taskService.createTask($event, null, []))
      .subscribe(_ => this.loadAll());
  }

  delete(uuid: string): void {
    this.deleteTaskCall.execute(this.taskService.deleteTask(uuid))
      .subscribe(_ => this.loadAll());
  }

  showDetail(uuid: string): void {
    console.log(`detail of uuid=${uuid}`);
  }

  getSeverity(task: TaskDTO) {
    if (!task.deadline) {
      return 'no-deadline';
    }

    if (this.getDaysUntilNow(task.deadline) < 0) {
      return 'overdue';
    }

    if (this.getDaysUntilNow(task.deadline) < 3) {
      return 'hot';
    }

    return 'cold';
  }

  private getMillisUntilNow(date: Date): number {
    const today = new Date();
    return new Date(date).getTime() - today.getTime();
  }

  private getDaysUntilNow(date: Date): number {
    const diff = this.getMillisUntilNow(date);
    return Math.floor(diff / (1000 * 3600 * 24));
  }
}
