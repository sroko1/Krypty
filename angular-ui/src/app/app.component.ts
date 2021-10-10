import { Component } from '@angular/core';
import { githubUrl, homeUrl, weatherUrl } from './models/links';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-ui';
  githubLink = githubUrl
  weatherLink = weatherUrl
  homeLink = homeUrl
}
