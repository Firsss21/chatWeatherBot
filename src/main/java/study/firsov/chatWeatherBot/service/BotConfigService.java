package study.firsov.chatWeatherBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.firsov.chatWeatherBot.command.Command;
import study.firsov.chatWeatherBot.repository.BotConfigRepo;

import java.util.List;

@Service
public class BotConfigService {
    @Autowired
    BotConfigRepo botConfigRepo;

    public String getTelegramCallbackAnswerTemp() {
        return this.botConfigRepo.findAll().get(0).getTelegramCallbackAnswerTemp();
    }

    public String getNowApiTemp() {
        return this.botConfigRepo.findAll().get(0).getNowWeatherApiTemp();
    }

    public List<Command> getAllCommands() {
        return botConfigRepo.findAll().get(0).getCommands();
    }

    public String getBotUsername() {
        return botConfigRepo.findAll().get(0).getName();
    }

    public String getBotAccessToken() {
        return botConfigRepo.findAll().get(0).getAccessToken();
    }
}
