import {Injectable} from '@angular/core';
import {ServiceCall} from './service-call';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestClientService {

  constructor(private http: HttpClient) {
  }

  get<RESPONSE>(url: string): ServiceCall<RESPONSE> {
    const serviceCall = new ServiceCall<RESPONSE>();
    serviceCall.execute(this.http.get<RESPONSE>(url));
    return serviceCall;
  }

}
