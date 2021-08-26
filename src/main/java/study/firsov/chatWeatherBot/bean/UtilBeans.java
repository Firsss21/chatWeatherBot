package study.firsov.chatWeatherBot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UtilBeans {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
