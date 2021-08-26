package study.firsov.chatWeatherBot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import study.firsov.chatWeatherBot.entity.ChatConfig;

import java.math.BigInteger;

@Repository
public interface ChatConfigRepo extends MongoRepository<ChatConfig, BigInteger> {
    ChatConfig findAllByChatId(Long id);

    void deleteByChatId(Long id);
}
