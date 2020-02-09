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
  x: TaskDTO[];
  y: TaskDTO[];

  constructor(private dataService: TaskDataService) {
  }

  getTasks(): Observable<OrderedTasks> {
    return this.dataService.getTasks().pipe(
      map(taskDTOS => this.order(taskDTOS))
    );
  }

  private order(taskDTOS: TaskDTO[]): OrderedTasks {

    const taskDTOS1 = taskDTOS
      .filter(task => !!task.deadline)
      .sort((a, b) =>
        new Date(a.deadline).getTime() - new Date(b.deadline).getTime());

    const taskDTOS2 = taskDTOS.filter(task => !task.deadline);

    return new OrderedTasks(taskDTOS1, taskDTOS2);
  }
}
