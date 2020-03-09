import {HttpErrorResponse} from '@angular/common/http';

export class RequestTracker {

}

export interface RequestState {
  loading: boolean;
  error: HttpErrorResponse;
  result: any;
}
