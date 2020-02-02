import {HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';

export class ServiceCall<T> {
  active: boolean = false;
  succesful: boolean = false;
  error: HttpErrorResponse;
  observable: Observable<T>;

  execute(call: Observable<T>): void {
    this.start();

    this.observable = call.pipe(
      tap(
        next => {
          this.success();
        },
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
