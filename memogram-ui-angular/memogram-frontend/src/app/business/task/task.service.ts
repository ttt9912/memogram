import {Injectable} from '@angular/core';
import {TaskDTO} from '../../generated/memogram-services';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private url = 'api/tasks';

  constructor(private http: HttpClient) {
  }

  getTasks(): Observable<TaskDTO[]> {
    return this.http.get<TaskDTO[]>(this.url);
  }
}
