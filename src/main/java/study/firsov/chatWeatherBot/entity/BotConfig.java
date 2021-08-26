package study.firsov.chatWeatherBot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import study.firsov.chatWeatherBot.command.Command;

import java.math.BigInteger;
import java.util.List;

// Конфиг бота будет в базе монго

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "bot_config")
public class BotConfig {
    @Id
    private BigInteger id;
    // имя бота
    private String name;
    //токен
    private String accessToken;
    // url for temp api
    private String nowWeatherApiTemp;
    // tg callback asnwer url
    private String telegramCallbackAnswerTemp;

    private List<Command> commands;
}

