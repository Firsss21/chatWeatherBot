package study.firsov.chatWeatherBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import study.firsov.chatWeatherBot.service.BotConfigService;

@SpringBootApplication
public class ChatWeatherBotApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatWeatherBotApplication.class, args);
	}
}
