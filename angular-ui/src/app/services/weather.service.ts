import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { SpringWeatherResponse } from '../models/weather.data';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  // constructor(private http: HttpClient) { }

  myName(): string {
    return "maniek"
  }

  readWeatherForecasts(): Observable<Array<SpringWeatherResponse>> {
    // return this.http.get<Array<SpringWeatherResponse>>(weatherApi)
    let response: Array<SpringWeatherResponse> = []
    response.push({
      moje_miasto: 'Olsztyn-Zdrój',
      temp_in_cs: 50,
      id: 1
    })
    response.push({
      moje_miasto: 'Poznan',
      temp_in_cs: 20,
      id: 2
    })
    return of(response)
  }
}
