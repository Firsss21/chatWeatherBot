package study.firsov.chatWeatherBot.bean;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import study.firsov.chatWeatherBot.WeatherBotFacade;
import study.firsov.chatWeatherBot.service.BotConfigService;

@Component
public class WeatherBot extends TelegramLongPollingBot {
    @Autowired
    private BotConfigService botConfigService;
    @Autowired
    private WeatherBotFacade weatherBotFacade;

    @Override
    public String getBotUsername() {
        return botConfigService.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botConfigService.getBotAccessToken();
    }


    @SneakyThrows //отслеживание Exceptions
    @Override
    public void onUpdateReceived(Update update) {
        weatherBotFacade.handleUpdate(update);
    }
}