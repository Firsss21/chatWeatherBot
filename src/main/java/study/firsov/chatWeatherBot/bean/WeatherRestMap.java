package study.firsov.chatWeatherBot.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import study.firsov.chatWeatherBot.cache.WeatherCache;
import study.firsov.chatWeatherBot.model.WeatherNow;
import study.firsov.chatWeatherBot.service.BotConfigService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WeatherRestMap {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BotConfigService botConfigService;

    /**
     * По городу получаем
     *
     * @param city
     * @return
     */
    @Cacheable(value = WeatherCache.NAME)
    public WeatherNow getNowWeather(String city) {
        try {
            Logger logger = LoggerFactory.getLogger(WeatherRestMap.class);
            logger.warn("not cached");
            return restTemplate.getForObject(
                    botConfigService.getNowApiTemp().replace("{city}", city),
                    WeatherNow.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //проверка существования города
    public boolean isCity(String city) throws IOException {

        URL weatherApiUrl = new URL(botConfigService.getNowApiTemp().replace("{city}", city));

        HttpURLConnection weatherApiConnection = (HttpURLConnection) weatherApiUrl.openConnection();
        weatherApiConnection.setRequestMethod("GET");
        weatherApiConnection.connect();
        return weatherApiConnection.getResponseCode() == HttpURLConnection.HTTP_OK;
    }
}