package study.firsov.chatWeatherBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import study.firsov.chatWeatherBot.command.Command;
import study.firsov.chatWeatherBot.repository.BotConfigRepo;

import java.util.List;

@Service
public class BotConfigService {
    @Autowired
    BotConfigRepo botConfigRepo;

    @Value("#{${bot.telegramCallbackAnswer}}")
    private String tgApi;

    @Value("#{${bot.weatherApi}}")
    private String nowApi;

    @Value("#{${bot.accessToken}}")
    private String tgAccessToken;

    @Value("#{${bot.name}}")
    private String username;

    public String getTelegramCallbackAnswerTemp() {
        return tgApi;
    }

    public String getNowApiTemp() {
        return nowApi;
    }

    public String getBotUsername() {
        return username;
    }

    public String getBotAccessToken() {
        return tgAccessToken;
    }
}
