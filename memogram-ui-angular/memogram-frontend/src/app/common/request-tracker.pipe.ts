import {Pipe, PipeTransform} from '@angular/core';
import {isObservable, of} from 'rxjs';
import {catchError, map, startWith} from 'rxjs/operators';

@Pipe({
  name: 'requestTracker'
})
export class RequestTrackerPipe implements PipeTransform {

  transform(val) {
    return !isObservable(val) ? val
      : val.pipe(
        map((value: any) => ({loading: false, value})),
        startWith({loading: true}),
        catchError(error => of({loading: false, error}))
      );
  }

}
