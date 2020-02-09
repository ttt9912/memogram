import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {TaskDTO} from '../../generated/memogram-services';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {
  private url = 'api/tasks';

  constructor(private http: HttpClient) {
  }

  getTasks(): Observable<TaskDTO[]> {
    return this.http.get<TaskDTO[]>(this.url);
  }
}
