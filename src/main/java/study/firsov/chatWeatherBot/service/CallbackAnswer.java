package study.firsov.chatWeatherBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CallbackAnswer {
    @Autowired
    private BotConfigService botConfigService;

    public void callbackAnswer(String callbackId) throws IOException, InterruptedException {
        HttpClient telegramApiClient = HttpClient.newHttpClient();
        HttpRequest telegramCallbackAnswerReq =
                HttpRequest.newBuilder(URI
                        .create(botConfigService
                                .getTelegramCallbackAnswerTemp()
                                .replace("{token}", botConfigService.getBotAccessToken())
                                .replace("{id}", callbackId)))
                        .GET().build();

        telegramApiClient.send(telegramCallbackAnswerReq, HttpResponse.BodyHandlers.ofString());
    }
}