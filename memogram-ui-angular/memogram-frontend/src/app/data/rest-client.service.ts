import {Injectable} from '@angular/core';
import {ServiceCall} from './service-call';
import {HttpClient, HttpHeaders} from '@angular/common/http';

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

  // TODO: service call
  delete(url: string, id: string): ServiceCall<any> {
    const serviceCall = new ServiceCall<any>(); // TODO: generic
    serviceCall.execute(this.http.delete(`${url}/${id}`, httpOptions));
    serviceCall.observable.subscribe();
    return serviceCall;
  }
}

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
