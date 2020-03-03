import {Component, OnInit} from '@angular/core';
import {TopicDataService} from '../../../data/topic/topic-data.service';
import {Note, Topic} from '../../../generated/memogram-services';
import {Observable} from 'rxjs';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-topic-detail',
  templateUrl: './topic-detail.component.html',
  styleUrls: ['./topic-detail.component.scss']
})
export class TopicDetailComponent implements OnInit {
  topic$: Observable<Topic>;

  topic: Topic;

  constructor(private topicDataService: TopicDataService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const key = this.route.snapshot.paramMap.get('key');
    this.topic$ = this.topicDataService.findByKey(key);

    this.topicDataService.findByKey(key)
      .subscribe(topic => this.topic = topic);
  }

  createNote($event: string) {
    const note: Note = {text: $event};
    this.topicDataService.createNote(this.topic.key, note).subscribe(
      () => {
        // this.topic$ = this.topicDataService.findByKey(key);
        this.topicDataService.findByKey(this.topic.key)
          .subscribe(topic => this.topic = topic);
      }
    );
  }
}
