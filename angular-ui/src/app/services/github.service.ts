import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { githubApi } from '../models/links';
import { GithubRepo } from '../models/github.data';

@Injectable({
  providedIn: 'root'
})
export class GithubService {

  constructor(private http: HttpClient) { }

  readGithubRepos(): Observable<Array<GithubRepo>> {
    return this.http.get<Array<GithubRepo>>(githubApi);
  }
}
