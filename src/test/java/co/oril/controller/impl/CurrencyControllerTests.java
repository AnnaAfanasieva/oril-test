package co.oril.controller.impl;

import co.oril.service.impl.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CurrencyControllerTests {

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    CurrencyController controller;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMinPrice() {
        String currencyName = "USDT";
        controller.minPrice(currencyName);
        verify(currencyService, times(1)).minPrice(currencyName);
    }

    @Test
    void testMaxPrice() {
        String currencyName = "USDT";
        controller.maxPrice(currencyName);
        verify(currencyService, times(1)).maxPrice(currencyName);
    }

    @Test
    void testListOfPrices() {
        String currencyName = "USDT";
        Long page = 0L;
        Long size = 10L;
        controller.listOfPrices(currencyName, page, size);
        verify(currencyService, times(1)).listOfPrices(currencyName, page, size);
    }

    @Test
    void testCsvReport() {
        controller.csvReport();
        verify(currencyService, times(1)).csvReport();
    }
}
