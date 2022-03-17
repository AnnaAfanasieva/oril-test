package co.oril.controller;

import co.oril.model.Currency;
import co.oril.service.CurrencyService;
import co.oril.util.ParseFromCite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cryptocurrencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/add")
    public ResponseEntity fetchCryptocurrencyPrices() {
        Currency currencyBTC = ParseFromCite.currencyFromCite(ParseFromCite.BTC_URL);
        Currency currencyETH = ParseFromCite.currencyFromCite(ParseFromCite.ETH_URL);
        Currency currencyXRP = ParseFromCite.currencyFromCite(ParseFromCite.XRP_URL);
        currencyService.fetchCryptocurrencyPrices(currencyBTC);
        currencyService.fetchCryptocurrencyPrices(currencyETH);
        currencyService.fetchCryptocurrencyPrices(currencyXRP);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/minprice")
    public ResponseEntity<Double> minPrice(@RequestParam(value = "name", required = false) String currencyName) {
        return ResponseEntity.ok(currencyService.minPrice(currencyName));
    }

    @GetMapping("/maxprice")
    public ResponseEntity maxPrice(@RequestParam(value = "name", required = false) String currencyName) {
        return ResponseEntity.ok(currencyService.maxPrice(currencyName));
    }

    //TODO повернути вибрану сторінку з вибраною кількістю елементів
    //сортування за умовчанням має здійснюватися за ціною від найнижчої до найвищої

    //Параметри запиту [page_number] і [page_size] мають бути необов’язковими
    //якщо вони відсутні, ви повинні встановити для них значення за замовчуванням page=0, size=10
    public void listOfPrices() {

    }

    @GetMapping("/csv")
    public ResponseEntity csvReport() {
        currencyService.csvReport();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
