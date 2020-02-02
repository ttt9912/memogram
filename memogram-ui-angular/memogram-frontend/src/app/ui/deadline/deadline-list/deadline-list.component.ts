import {Component, OnInit} from '@angular/core';
import {DeadlineService} from '../../../business/deadline/deadline.service';
import {Deadline} from '../../../business/deadline/deadline';

@Component({
  selector: 'app-deadline-list',
  templateUrl: './deadline-list.component.html',
  styleUrls: ['./deadline-list.component.scss']
})
export class DeadlineListComponent implements OnInit {
  private deadlines: Deadline[];

  constructor(private deadlineService: DeadlineService) {
  }

  ngOnInit() {
    console.log('starting get');
    this.deadlineService.getDeadlines().observable
      .subscribe(res => this.deadlines = res);
  }

}
