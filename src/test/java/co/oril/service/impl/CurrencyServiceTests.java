package co.oril.service.impl;

import co.oril.model.Currency;
import co.oril.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CurrencyServiceTests {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyService service;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchCryptocurrencyPrices() {
        Currency currency = new Currency("USDT", 1234.5);
        service.fetchCryptocurrencyPrices(currency);
        verify(currencyRepository, times(1)).insert(currency);
    }

    @Test
    void testListOfPrices() {
        String currencyName = "USDT";
        Long page = 0L;
        Long size = 10L;
        service.listOfPrices(currencyName, page, size);
        verify(currencyRepository, times(1)).findAllByCurrencyNameOrderByCurrencyPrice(currencyName);
    }
}
