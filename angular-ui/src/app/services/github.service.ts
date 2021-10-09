import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { githubApi } from '../models/links';

@Injectable({
  providedIn: 'root'
})
export class GithubService {

  constructor(private http: HttpClient) { }

  readGithubRepos(): Observable<Array<any>> {
    return this.http.get<Array<any>>(githubApi);
  }
}
