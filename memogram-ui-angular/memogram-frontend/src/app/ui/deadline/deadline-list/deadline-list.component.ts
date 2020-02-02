import {Component, OnInit} from '@angular/core';
import {DeadlineService} from '../../../data/deadline/deadline.service';

@Component({
  selector: 'app-deadline-list',
  templateUrl: './deadline-list.component.html',
  styleUrls: ['./deadline-list.component.scss']
})
export class DeadlineListComponent implements OnInit {

  constructor(private deadlineService: DeadlineService) {
  }

  ngOnInit() {
    console.log('starting get');
    this.deadlineService.getDeadlines().observable
      .subscribe(res => console.log(res));
  }

}
