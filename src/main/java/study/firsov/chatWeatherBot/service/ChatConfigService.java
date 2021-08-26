package study.firsov.chatWeatherBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.firsov.chatWeatherBot.bean.BotState;
import study.firsov.chatWeatherBot.entity.ChatConfig;
import study.firsov.chatWeatherBot.repository.ChatConfigRepo;

@Service
public class ChatConfigService {
    @Autowired
    private ChatConfigRepo chatConfigRepo;

    /**
     * Если такой чат уже существует, то true, иначе false
     *
     * @param chatId
     * @return
     */
    public boolean isChatInit(Long chatId) {
        return chatConfigRepo.findAllByChatId(chatId) != null;
    }

    /**
     * Сохраняем в бд новую запись о чате
     *
     * @param chatId
     */
    public void initChat(Long chatId) {
        chatConfigRepo.save(new ChatConfig(chatId, BotState.DEFAULT));
    }

    /**
     * Удаляем из бд запись по chatId
     *
     * @param chatId
     */
    public void deleteChat(Long chatId) {
        chatConfigRepo.deleteByChatId(chatId);
    }

    /**
     * Устанавливает новый стейт для чата
     *
     * @param chatId
     * @param botState
     */
    public void setBotState(Long chatId, BotState botState) {
        ChatConfig chatConfig = chatConfigRepo.findAllByChatId(chatId);
        chatConfig.setBotState(botState);
        chatConfigRepo.save(chatConfig);
    }

    /**
     * Получает стейт чата
     *
     * @param chatId
     */
    public BotState getBotState(Long chatId) {
        return chatConfigRepo.findAllByChatId(chatId).getBotState();
    }

    /**
     * Устанавливает чату город
     *
     * @param chatId
     * @param city
     */
    public void setCity(Long chatId, String city) {
        ChatConfig chatConfig = chatConfigRepo.findAllByChatId(chatId);
        chatConfig.setCity(city);
        chatConfigRepo.save(chatConfig);
    }

    /**
     * Получает город чата
     *
     * @param chatId
     * @return
     */
    public String getCity(Long chatId) {
        return chatConfigRepo.findAllByChatId(chatId).getCity();
    }
}