import { Component, OnInit } from '@angular/core';
import { WeatherService } from '../../services/weather.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {
  name: string = ""

  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
    this.name = this.weatherService.myName()
  }

}
