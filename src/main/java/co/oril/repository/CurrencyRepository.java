package co.oril.repository;

import co.oril.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CurrencyRepository extends MongoRepository<Currency, String> {

    @Query("{'currencyName':?0}")
    List<Currency> findAllByCurrencyName(String name);

    @Query("{'currencyName':?0}")
    List<Currency> findAllByCurrencyNameOrderByCurrencyPrice(String name);
}
