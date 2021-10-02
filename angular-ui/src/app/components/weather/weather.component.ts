import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../../services/weather.service';
import { SpringWeatherResponse } from '../../models/weather.data';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  name: string = ""
  response!: Array<SpringWeatherResponse>
  // response!: SpringWeatherResponse[]

  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
    this.name = this.weatherService.myName()
    this.weatherService.readWeatherForecasts()
      .subscribe(value => {
        this.response = value
        console.log(`received value: ${value}`)
      })
    console.log('ngOnInit completed');
  }

}
