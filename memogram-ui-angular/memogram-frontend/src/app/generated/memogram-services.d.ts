/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.19.577 on 2020-02-19 15:20:42.

export interface BlockerCreateCommand {
    title: string;
    options: Timebox[];
}

export interface BlockerUpdateCommand {
    uuid: string;
    title: string;
    options: Timebox[];
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

export interface TaskDTO {
    id: string;
    title: string;
    deadline: Date;
}

export interface Timebox {
    start: Date;
    end: Date;
}
