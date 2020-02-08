import {Component, OnInit} from '@angular/core';
import {MotiveDTO} from '../../../generated/memogram-services';
import {ServiceCall} from '../../../data/service-call';
import {MotiveService} from '../../../business/motive/motive.service';

@Component({
  selector: 'app-motive-list',
  templateUrl: './motive-list.component.html',
  styleUrls: ['./motive-list.component.scss']
})
export class MotiveListComponent implements OnInit {
  private motives: MotiveDTO[];

  private motiveCall: ServiceCall<MotiveDTO[]>;
  private deleteMotiveCall: ServiceCall<void>;

  constructor(private motiveService: MotiveService) {
  }

  ngOnInit() {
    this.motiveCall = this.motiveService.getMotives();
    this.motiveCall.observable.subscribe(
      res => this.motives = res
    );
  }

  showDetail(uuid: string): void {
    console.log(`detail of uuid=${uuid}`);
  }

  delete(uuid: string): void {
    this.deleteMotiveCall = this.motiveService.delete(uuid);
    console.log(`delete uuid=${uuid}`);
  }
}
