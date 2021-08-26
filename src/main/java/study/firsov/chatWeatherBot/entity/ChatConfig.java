package study.firsov.chatWeatherBot.entity;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import study.firsov.chatWeatherBot.bean.BotState;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "chats_config")
public class ChatConfig {
    @Id
    private BigInteger id;

    @NonNull
    private Long chatId;

    @NonNull
    @Field(targetType = FieldType.STRING)
    private BotState botState;

    private String city;

    public ChatConfig(Long chatId, BotState aDefault) {
        this.chatId = chatId;
        this.botState = aDefault;
    }
}