import {TestBed} from '@angular/core/testing';

import {TopicDataService} from './topic-data.service';

describe('TopicDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TopicDataService = TestBed.get(TopicDataService);
    expect(service).toBeTruthy();
  });
});
