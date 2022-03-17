package co.oril.repository;

import co.oril.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseRepository extends MongoRepository<Currency, String> {
}
