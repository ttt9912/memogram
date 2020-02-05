import {Injectable} from '@angular/core';
import {ServiceCall} from '../../data/service-call';
import {RestClientService} from '../../data/rest-client.service';
import {DeadlineDTO} from '../../generated/memogram-services';

@Injectable({
  providedIn: 'root'
})
export class DeadlineService {
  private url = 'api/deadlines';

  constructor(private restClient: RestClientService) {
  }

  getDeadlines(): ServiceCall<DeadlineDTO[]> {
    return this.restClient.get<DeadlineDTO[]>(this.url);
  }
}
