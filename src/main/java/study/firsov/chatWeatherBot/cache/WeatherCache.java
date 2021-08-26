package study.firsov.chatWeatherBot.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import study.firsov.chatWeatherBot.bean.WeatherRestMap;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@EnableCaching
@EnableScheduling
public class WeatherCache {
    public static final String NAME = "weather";

    Logger logger = LoggerFactory.getLogger(WeatherCache.class);

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(NAME);
        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {NAME})
    @Scheduled(fixedDelay = 5 * 60 * 1000, initialDelay = 500)
    public void reportCacheEvict() {
        logger.info("Flush Cache " + DateFormat.getTimeInstance().format(new Date()));
    }
}
