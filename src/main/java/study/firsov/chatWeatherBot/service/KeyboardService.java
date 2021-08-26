package study.firsov.chatWeatherBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import study.firsov.chatWeatherBot.bean.MessageGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KeyboardService {
    private final InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
    private final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    @Autowired
    private ChatConfigService chatConfigService;
    @Autowired
    private MessageGenerator messageGenerator;

    public InlineKeyboardMarkup setChooseCityKeyboard(Long chatId) {
        List<InlineKeyboardButton> keyboardRow = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();

        //текст на кнопке
        String city = chatConfigService.getCity(chatId);
        if (city == null) {
            city = "Moscow";
        }
        button1.setText(city);

        //сообщение, которое она возвращает
        button1.setCallbackData(getCurrentCityNowButton(chatConfigService
                .getCity(chatId)));

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Другой");
        button2.setCallbackData(getChooseCityNowButtonData());

        keyboardRow.add(button1);
        keyboardRow.add(button2);
        keyboard.setKeyboard(Arrays.asList(keyboardRow));

        return keyboard;
    }

    public ReplyKeyboardMarkup setGetNowKeyboard(Long chatId) {

        List<KeyboardRow> keyboardRow = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(messageGenerator.generateMenuWeather());
        keyboardRow.add(row);
        replyKeyboardMarkup.setKeyboard(keyboardRow);
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    public String getChooseCityNowButtonData() {
        return "Введите необходимый город";
    }

    public String getCurrentCityNowButton(String city) {
        return "Сейчас " + city;
    }
}