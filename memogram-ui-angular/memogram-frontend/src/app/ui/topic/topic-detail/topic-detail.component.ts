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
  topic: Topic;

  private id: string;

  constructor(private topicDataService: TopicDataService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.loadTopic();
  }

  createNote($event: string) {
    this.topicDataService.createNote(this.id, $event).subscribe(
      () => this.loadTopic()
    );
  }

  private loadTopic() {
    // observable - interrupts ui
    this.topic$ = this.topicDataService.findById(this.id);

    // non observable // TODO: track via calltracker (non pipe)
    this.topicDataService.findById(this.id)
      .subscribe(res => this.topic = res);
  }
}
