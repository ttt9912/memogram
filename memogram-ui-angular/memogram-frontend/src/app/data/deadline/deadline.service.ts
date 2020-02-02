import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Deadline} from './deadline';
import {ServiceCall} from '../service-call';

@Injectable({
  providedIn: 'root'
})
export class DeadlineService {
  private url = 'api/deadlines';

  constructor(private http: HttpClient) {
  }

  getDeadlines(): ServiceCall<Deadline[]> {
    const serviceCall = new ServiceCall<Deadline[]>();
    serviceCall.execute(this.http.get<Deadline[]>(this.url));
    return serviceCall;
  }
}
