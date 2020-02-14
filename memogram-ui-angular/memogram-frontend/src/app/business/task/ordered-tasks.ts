import {TaskDTO} from '../../generated/memogram-services';

export class OrderedTasks {
  constructor(public withDeadline: TaskDTO[],
              public withoudDeadline: TaskDTO[]) {
  }
}
