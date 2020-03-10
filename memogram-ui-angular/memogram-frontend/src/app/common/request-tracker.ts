import {HttpErrorResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, map} from 'rxjs/operators';

export class RequestTracker<T> {
  loading = false;
  error: HttpErrorResponse;

  start() {
    this.loading = true;
  }

  success(result: T): T {
    this.loading = false;
    return result;
  }

  fail(error: HttpErrorResponse): Observable<never> {
    this.loading = false;
    this.error = error;
    return throwError(error);
  }

  execute(request: Observable<T>): Observable<T> {
    this.start();
    return request.pipe(
      map(res => this.success(res)),
      catchError(error => this.fail(error))
    );
  }

}
