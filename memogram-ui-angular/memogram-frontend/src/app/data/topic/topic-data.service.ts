import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Topic, TopicKey} from '../../generated/memogram-services';

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

  findById(id: string): Observable<Topic> {
    return this.http.get<Topic>(`${this.url}/${id}`);
  }

  findDeleted(): Observable<Topic[]> {
    return this.http.get<Topic[]>(`${this.url}/deleted`);
  }

  create(title: string): Observable<TopicKey> {
    return this.http.post<TopicKey>(this.url, title);
  }

  createNote(topicId: string, note: string): Observable<any> {
    return this.http.patch(`${this.url}/${topicId}`, note);
  }

  delete(topicId: string): Observable<any> {
    return this.http.delete(`${this.url}/${topicId}`);
  }
}
