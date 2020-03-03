import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Note, Topic} from '../../generated/memogram-services';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TopicDataService {
  private url = 'api/topics';

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Topic[]> {
    return this.http.get<Topic[]>(this.url);
  }

  findByKey(key): Observable<Topic> {
    return this.http.get<Topic>(`${this.url}/${key}`);
  }

  create(title: string): Observable<string> { // todo TopicKey
    return this.http.post<string>(this.url, title);
  }

  createNote(topicKey: string, note: Note): Observable<any> { // todo TopicKey
    return this.http.patch(`${this.url}/${topicKey}`, note);
  }
}
