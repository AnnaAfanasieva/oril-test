package co.oril.service.impl;

import co.oril.model.Currency;
import co.oril.repository.CurrencyRepository;
import co.oril.service.BaseService;
import co.oril.util.CSV;
import co.oril.util.FindMinAndMaxPrice;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class CurrencyService implements BaseService {

    private final CurrencyRepository currencyRepository;
    private static final String PATH_TO_REPORT = "csv/report.csv";

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void fetchCryptocurrencyPrices(Currency currency) {
        currencyRepository.insert(currency);
    }

    public Double minPrice(String currencyName) {
        List<Currency> currencies = currencyRepository.findAllByCurrencyName(currencyName);
        return FindMinAndMaxPrice.findMinPrice(currencies);
    }

    public Double maxPrice(String currencyName) {
        List<Currency> currencies = currencyRepository.findAllByCurrencyName(currencyName);
        return FindMinAndMaxPrice.findMaxPrice(currencies);
    }

    public List<Currency> listOfPrices(String currencyName, Long page, Long size) {
        List<Currency> currencies = currencyRepository.findAllByCurrencyNameOrderByCurrencyPrice(currencyName);
        currencies = currencies.stream().sorted(Comparator.comparingDouble(Currency::getCurrencyPrice)).toList();
        int startCurrency = (int) (page * size);
        int endCurrency = (int) ((page + 1) * size);
        int sizeCurrencies = currencies.size();
        if (startCurrency > sizeCurrencies || startCurrency < 0) {
            return null;
        }
        if (endCurrency > sizeCurrencies) {
            endCurrency = sizeCurrencies;
        }
        currencies = currencies.subList(startCurrency, endCurrency);
        return currencies;
    }

    public void csvReport() {
        List<Currency> currenciesBTC = currencyRepository.findAllByCurrencyName("BTC");
        List<Currency> currenciesETH = currencyRepository.findAllByCurrencyName("ETH");
        List<Currency> currenciesXRP = currencyRepository.findAllByCurrencyName("XRP");
        String recordBTC = CSV.createLineFromList(currenciesBTC);
        String recordETH = CSV.createLineFromList(currenciesETH);
        String recordXRP = CSV.createLineFromList(currenciesXRP);

        File file = new File(PATH_TO_REPORT);
        if (!file.isFile()) {
            try {
                boolean newFile = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        CSV.cleanCSVFile(PATH_TO_REPORT);
        CSV.writeStringToCSVFile(PATH_TO_REPORT, recordBTC);
        CSV.writeStringToCSVFile(PATH_TO_REPORT, recordETH);
        CSV.writeStringToCSVFile(PATH_TO_REPORT, recordXRP);
    }
}
