import {Component, OnInit} from '@angular/core';
import {DeadlineService} from '../../../business/deadline/deadline.service';
import {Deadline} from '../../../business/deadline/deadline';
import {ServiceCall} from '../../../data/service-call';

@Component({
  selector: 'app-deadline-list',
  templateUrl: './deadline-list.component.html',
  styleUrls: ['./deadline-list.component.scss']
})
export class DeadlineListComponent implements OnInit {
  private deadlines: Deadline[];
  private deadlinesCall: ServiceCall<Deadline[]>;

  constructor(private deadlineService: DeadlineService) {
  }

  ngOnInit() {
    this.deadlinesCall = this.deadlineService.getDeadlines();
    this.deadlinesCall.observable.subscribe(
      res => this.deadlines = res
    )
  }

}
