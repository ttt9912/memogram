import {Component, OnInit} from '@angular/core';
import {DeadlineService} from '../../../business/deadline/deadline.service';
import {ServiceCall} from '../../../data/service-call';
import {DeadlineDTO} from '../../../generated/memogram-services';

@Component({
  selector: 'app-deadline-list',
  templateUrl: './deadline-list.component.html',
  styleUrls: ['./deadline-list.component.scss']
})
export class DeadlineListComponent implements OnInit {
  private deadlines: DeadlineDTO[];
  private deadlinesCall: ServiceCall<DeadlineDTO[]>;

  constructor(private deadlineService: DeadlineService) {
  }

  ngOnInit() {
    this.deadlinesCall = this.deadlineService.getDeadlines();
    this.deadlinesCall.observable.subscribe(
      res => this.deadlines = res
    );
  }


  showDetail(uuid: string): void {
    console.log(`detail of uuid=${uuid}`);
  }

  delete(uuid: string): void {

  }
}
