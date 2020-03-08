import {Component, OnInit} from '@angular/core';
import {TopicDataService} from '../../../data/topic/topic-data.service';
import {Observable} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {Topic} from '../../../generated/memogram-services';

@Component({
  selector: 'app-topic-detail',
  templateUrl: './topic-detail.component.html',
  styleUrls: ['./topic-detail.component.scss']
})
export class TopicDetailComponent implements OnInit {
  topic$: Observable<Topic>;

  private id: string;

  constructor(private topicDataService: TopicDataService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.topic$ = this.topicDataService.findById(this.id);
  }

  createNote($event: string) {
    this.topicDataService.createNote(this.id, $event).subscribe(
      () => {
        this.topic$ = this.topicDataService.findById(this.id);
      }
    );
  }
}
