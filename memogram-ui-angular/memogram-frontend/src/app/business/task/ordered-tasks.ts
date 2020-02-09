import {TaskDTO} from '../../generated/memogram-services';

export class OrderedTasks {
  // withDeadline: TaskDTO[];
  // withoudDeadline: TaskDTO[];

  constructor(public withDeadline: TaskDTO[], public withoudDeadline: TaskDTO[]) {
  }
}
