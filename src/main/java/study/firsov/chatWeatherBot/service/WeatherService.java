package study.firsov.chatWeatherBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.firsov.chatWeatherBot.bean.WeatherRestMap;
import study.firsov.chatWeatherBot.model.WeatherNow;

import java.io.IOException;

@Service
public class WeatherService {
    @Autowired
    WeatherRestMap weatherRestMap;

    public boolean isCity(String city) throws IOException {
        return weatherRestMap.isCity(city);
    }

    public WeatherNow getCurrentWeather(String city) {
        return weatherRestMap.getNowWeather(city);
    }
}
