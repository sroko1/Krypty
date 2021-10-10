import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { SpringWeatherResponse } from '../models/weather.data';
import { HttpClient } from '@angular/common/http';
import { weatherApi } from '../models/links';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  constructor(private http: HttpClient) { }

  myName(): string {
    return "maniek"
  }

  readWeatherForecasts(): Observable<Array<SpringWeatherResponse>> {
    return this.http.get<Array<SpringWeatherResponse>>(weatherApi)
  }
}
