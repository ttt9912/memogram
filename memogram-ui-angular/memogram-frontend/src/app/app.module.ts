import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DeadlineListComponent} from './ui/deadline/deadline-list/deadline-list.component';
import {HttpClientModule} from '@angular/common/http';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule, PanelModule} from 'primeng';
import {MotiveListComponent} from './ui/motive/motive-list/motive-list.component';

@NgModule({
  declarations: [
    AppComponent,
    DeadlineListComponent,
    MotiveListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NoopAnimationsModule,
    PanelModule,
    ButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
