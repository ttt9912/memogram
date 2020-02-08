import {Injectable} from '@angular/core';
import {ServiceCall} from '../../data/service-call';
import {RestClientService} from '../../data/rest-client.service';
import {TaskDTO} from '../../generated/memogram-services';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private url = 'api/deadlines';

  constructor(private restClient: RestClientService) {
  }

  getDeadlines(): ServiceCall<TaskDTO[]> {
    return this.restClient.get<TaskDTO[]>(this.url);
  }
}
