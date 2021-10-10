import { Component, OnInit } from '@angular/core';
import { GithubService } from '../../services/github.service';
import { GithubRepo } from '../../models/github.data';

@Component({
  selector: 'app-github',
  templateUrl: './github.component.html',
  styleUrls: ['./github.component.css']
})
export class GithubComponent implements OnInit {
  repos: GithubRepo[] = [];
  displayedColumns = [ 'fullName', 'login', 'type', 'forksUrl'];

  constructor(private github: GithubService) { }

  ngOnInit(): void {
    this.github.readGithubRepos()
      .subscribe(value => this.repos = value)
  }

}
