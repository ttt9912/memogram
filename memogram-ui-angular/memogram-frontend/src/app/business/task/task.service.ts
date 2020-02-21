import {Injectable} from '@angular/core';
import {TaskDataService} from '../../data/task/task-data.service';
import {Observable} from 'rxjs';
import {Tag, TaskCreateCommand, TaskDTO} from '../../generated/memogram-services';
import {map} from 'rxjs/operators';
import {OrderedTasks} from './ordered-tasks';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private dataService: TaskDataService) {
  }

  getTasks(): Observable<OrderedTasks> {
    return this.dataService.findAll().pipe(
      map(taskDTOS => this.order(taskDTOS))
    );
  }

  createTask(title: string, deadline: Date, tags: Tag[]): Observable<any> {
    const command: TaskCreateCommand = {title, deadline, tags};
    return this.dataService.create(command);
  }

  deleteTask(id: string): Observable<any> {
    return this.dataService.delete(id);
  }

  private order(taskDTOS: TaskDTO[]): OrderedTasks {
    return new OrderedTasks(
      this.orderByDeadline(taskDTOS),
      this.getWithoutDeadline(taskDTOS));
  }

  private orderByDeadline(taskDTOs: TaskDTO[]): TaskDTO[] {
    return this.getWithDeadline(taskDTOs)
      .sort((a, b) =>
        new Date(a.deadline).getTime() - new Date(b.deadline).getTime());
  }

  private getWithDeadline(taskDTOs: TaskDTO[]): TaskDTO[] {
    return taskDTOs.filter(task => !!task.deadline);
  }

  private getWithoutDeadline(taskDTOs: TaskDTO[]): TaskDTO[] {
    return taskDTOs.filter(task => !task.deadline);
  }
}
