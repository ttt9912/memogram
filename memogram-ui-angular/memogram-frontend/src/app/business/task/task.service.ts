import {Injectable} from '@angular/core';
import {TaskDataService} from '../../data/task/task-data.service';
import {Observable} from 'rxjs';
import {TaskDTO} from '../../generated/memogram-services';
import {map} from 'rxjs/operators';
import {OrderedTasks} from './ordered-tasks';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private dataService: TaskDataService) {
  }

  getTasks(): Observable<OrderedTasks> {
    return this.dataService.getTasks().pipe(
        map(taskDTOS => this.order(taskDTOS))
    );
  }

  private order(taskDTOS: TaskDTO[]): OrderedTasks {
    return new OrderedTasks(
        this.orderByDeadline(taskDTOS),
        this.getWithoutDeadline(taskDTOS));
  }


  private orderByDeadline(taskDTOs: TaskDTO[]) {
    return this.getWithDeadline(taskDTOs)
        .sort((a, b) =>
            new Date(a.deadline).getTime() - new Date(b.deadline).getTime());
  }

  private getWithDeadline(taskDTOs: TaskDTO[]) {
    return taskDTOs.filter(task => !!task.deadline);
  }

  private getWithoutDeadline(taskDTOs: TaskDTO[]) {
    return taskDTOs.filter(task => !task.deadline);
  }
}
