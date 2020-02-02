import {Injectable} from '@angular/core';
import {ServiceCall} from '../../data/service-call';
import {Deadline} from './deadline';
import {RestClientService} from '../../data/rest-client.service';

@Injectable({
  providedIn: 'root'
})
export class DeadlineService {
  private url = 'api/deadlines';

  constructor(private restClient: RestClientService) {
  }

  getDeadlines(): ServiceCall<Deadline[]> {
    return this.restClient.get<Deadline[]>(this.url);
  }
}
