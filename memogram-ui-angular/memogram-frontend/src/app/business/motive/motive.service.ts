import {Injectable} from '@angular/core';
import {ServiceCall} from '../../data/service-call';
import {MotiveDTO} from '../../generated/memogram-services';
import {RestClientService} from '../../data/rest-client.service';

@Injectable({
  providedIn: 'root'
})
export class MotiveService {
  private url = 'api/motives';

  constructor(private restClient: RestClientService) {
  }

  getMotives(): ServiceCall<MotiveDTO[]> {
    return this.restClient.get<MotiveDTO[]>(this.url);
  }

  delete(uuid: string): ServiceCall<void> {
    return this.restClient.delete(this.url, uuid);
  }
}
