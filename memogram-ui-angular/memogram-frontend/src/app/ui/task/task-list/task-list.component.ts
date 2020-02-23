import {Component, OnInit} from '@angular/core';
import {TaskDTO} from '../../../generated/memogram-services';
import {TaskService} from '../../../business/task/task.service';
import {OrderedTasks} from '../../../business/task/ordered-tasks';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  orderedTasks$: Observable<OrderedTasks>;

  tasks: TaskDTO[];

  input: string;

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
    this.loadAll();

    // trial
    this.taskService.getTasks()
      .subscribe(res => this.tasks = res.withoudDeadline);
  }

  loadAll() {
    this.orderedTasks$ = this.taskService.getTasks();
  }

  createTask($event: string) {
    // TODO track this call
    this.taskService.createTask($event, null, [])
      .subscribe(_ => this.loadAll());

    // trial

  }

  delete(uuid: string): void {
    // TODO track this call
    this.taskService.deleteTask(uuid)
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
