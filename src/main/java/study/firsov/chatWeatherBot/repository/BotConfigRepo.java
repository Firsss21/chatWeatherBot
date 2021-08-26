package study.firsov.chatWeatherBot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import study.firsov.chatWeatherBot.entity.BotConfig;

import java.math.BigInteger;

@Repository
public interface BotConfigRepo extends MongoRepository<BotConfig, BigInteger> {
}
