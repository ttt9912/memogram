import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {TaskCreateCommand, TaskDTO} from '../../generated/memogram-services';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {
  private url = 'api/tasks';

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<TaskDTO[]> {
    return this.http.get<TaskDTO[]>(this.url);
  }

  create(command: TaskCreateCommand): Observable<any> {
    return this.http.post(this.url, command);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}
