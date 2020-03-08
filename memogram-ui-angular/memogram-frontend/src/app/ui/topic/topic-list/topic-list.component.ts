import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {TopicDataService} from '../../../data/topic/topic-data.service';
import {Router} from '@angular/router';
import {log} from 'util';
import {Topic} from '../../../generated/memogram-services';

@Component({
  selector: 'app-topic-list',
  templateUrl: './topic-list.component.html',
  styleUrls: ['./topic-list.component.scss']
})
export class TopicListComponent implements OnInit {
  topics$: Observable<Topic[]>;
  deletedTopics$: Observable<Topic[]>;

  constructor(private topicDataService: TopicDataService,
              private router: Router) {
  }

  ngOnInit() {
    this.loadTopics();
  }

  createTopic($event: string) {
    this.topicDataService.create($event)
      .subscribe(
        key => {
          console.log('saved topic with id=' + key.id);
          this.router.navigate(['app', 'topics', key.id]);
        },
        error => log(error.message)
      );
  }

  delete(id: string) {
    this.topicDataService.delete(id).subscribe(
      () => this.loadTopics()
    );
  }

  restore(id: string) {
    console.log('not implemented');
  }

  private loadTopics() {
    this.topics$ = this.topicDataService.findAll();
    this.deletedTopics$ = this.topicDataService.findDeleted();
  }
}
