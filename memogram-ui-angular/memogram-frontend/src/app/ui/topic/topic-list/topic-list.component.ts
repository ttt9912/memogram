import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Topic} from '../../../generated/memogram-services';
import {TopicDataService} from '../../../data/topic/topic-data.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-topic-list',
  templateUrl: './topic-list.component.html',
  styleUrls: ['./topic-list.component.scss']
})
export class TopicListComponent implements OnInit {
  topics$: Observable<Topic[]>;

  constructor(private topicDataService: TopicDataService,
              private router: Router) {
  }

  ngOnInit() {
    this.topics$ = this.topicDataService.findAll();
  }

  createTopic($event: string) {
    this.topicDataService.create($event).subscribe(
      key => this.router.navigate(['topics', key])
    );
  }
}
