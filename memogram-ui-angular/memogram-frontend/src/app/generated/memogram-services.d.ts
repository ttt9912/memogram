/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.19.577 on 2020-02-06 23:49:50.

export interface DeadlineDTO {
  id: string;
  title: string;
  deadline: Date;
}

export interface MotiveDTO {
  id: string;
  title: string;
  completed: boolean;
  tags: Tag[];
}

export interface Tag {
  name: string;
}
