/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.19.577 on 2020-02-10 00:01:11.

export interface DomainRequest<KEY, COMMAND> {
  key: KEY;
  command: COMMAND;
}

export interface TaskCreateRequest extends DomainRequest<TaskKey, TaskCreateCommand> {
  key: TaskKey;
  command: TaskCreateCommand;
}

export interface TaskDTO {
  id: string;
  title: string;
  deadline: Date;
}

export interface TaskUpdateRequest extends DomainRequest<TaskKey, TaskUpdateCommand> {
  key: TaskKey;
  command: TaskUpdateCommand;
}

export interface TaskKey {
  id: string;
}

export interface TaskCreateCommand {
  title: string;
  deadline: Date;
}

export interface TaskUpdateCommand {
  uuid: string;
  title: string;
  deadline: Date;
}
