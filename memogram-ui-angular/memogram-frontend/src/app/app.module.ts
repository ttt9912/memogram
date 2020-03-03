import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {TaskListComponent} from './ui/task/task-list/task-list.component';
import {HttpClientModule} from '@angular/common/http';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule, InputTextModule, PanelModule, PickListModule} from 'primeng';
import {InputComponent} from './ui/shared/input/input.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RequestTrackerPipe} from './common/request-tracker.pipe';
import {TopicListComponent} from './ui/topic/topic-list/topic-list.component';
import {TopicDetailComponent} from './ui/topic/topic-detail/topic-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskListComponent,
    InputComponent,
    RequestTrackerPipe,
    TopicListComponent,
    TopicDetailComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        NoopAnimationsModule,
        PanelModule,
        ButtonModule,
        PickListModule,
        InputTextModule,
        ReactiveFormsModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
