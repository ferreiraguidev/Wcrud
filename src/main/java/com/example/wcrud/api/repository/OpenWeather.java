package com.example.wcrud.api.repository;


import com.example.wcrud.api.dtos.WeatherResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.openweathermap.org/data/2.5/weather", name = "openWeatherClient")
public interface OpenWeather {

    @GetMapping
    WeatherResponseDTO searchWeatherByCity(@RequestParam("q") String city,
                                           @RequestParam("appid") String appid,
                                           @RequestParam("units") String units);

}
