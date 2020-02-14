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
  private orderedTasks: OrderedTasks;
  private tasksCall = new ServiceCallTracker<OrderedTasks>();
  input: string;

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
    this.loadAll();
  }

  onEnter() {
    console.log(`Entered ${this.input}`);
    this.input = '';
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

    if (this.getDaysUntilNow(task.deadline) < 0) {
      return 'overdue';
    }

    if (this.getDaysUntilNow(task.deadline) < 3) {
      return 'hot';
    }

    return 'cold';
  }

  addTask($event: string) {
    console.log($event);
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
