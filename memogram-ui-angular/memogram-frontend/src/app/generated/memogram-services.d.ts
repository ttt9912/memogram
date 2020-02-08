/* tslint:disable */
/* eslint-disable */

// Generated using typescript-generator version 2.19.577 on 2020-02-08 15:34:55.

export interface CreateTaskCommand {
  title: string;
  deadline: Date;
}

export interface UpdateTaskCommand {
  uuid: string;
  title: string;
  deadline: Date;
}

export interface TaskDTO {
  id: string;
  title: string;
  deadline: Date;
}
