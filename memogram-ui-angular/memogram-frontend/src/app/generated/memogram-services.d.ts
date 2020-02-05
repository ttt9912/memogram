/* tslint:disable */
/* eslint-disable */

// Generated using typescript-generator version 2.19.577 on 2020-02-05 23:08:02.

export interface DeadlineDTO {
  uuid: string;
  title: string;
  deadline: Date;
}

export interface MotiveDTO {
  uuid: string;
  title: string;
  completed: boolean;
  tags: Tag[];
}

export interface Tag {
  name: string;
}
