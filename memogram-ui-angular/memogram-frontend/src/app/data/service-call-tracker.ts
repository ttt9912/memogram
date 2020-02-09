import {HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {delay, tap} from 'rxjs/operators';

export class ServiceCallTracker<T> {
  active = false;
  succesful = false;
  error: HttpErrorResponse;

  execute(call: Observable<T>): Observable<T> {
    this.start();

    return call.pipe(
      delay(1000),
      tap(
        _ => this.success(),
        error => {
          this.fail();
          this.error = error;
        })
    );
  }

  private start(): void {
    this.active = true;
    this.succesful = false;
  }

  private fail(): void {
    this.active = false;
    this.succesful = false;
  }

  private success(): void {
    this.active = false;
    this.succesful = true;
  }
}
