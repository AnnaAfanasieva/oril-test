package co.oril.controller.impl;

import co.oril.controller.BaseController;
import co.oril.model.Currency;
import co.oril.service.impl.CurrencyService;
import co.oril.util.ParseFromCite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrencies")
public class CurrencyController extends BaseController {

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
    public ResponseEntity<Double> minPrice(@RequestParam(value = "name") String currencyName) {
        return ResponseEntity.ok(currencyService.minPrice(currencyName));
    }

    @GetMapping("/maxprice")
    public ResponseEntity<Double> maxPrice(@RequestParam(value = "name") String currencyName) {
        return ResponseEntity.ok(currencyService.maxPrice(currencyName));
    }

    @GetMapping()
    public ResponseEntity<List<Currency>> listOfPrices(
            @RequestParam(value = "name") String currencyName,
            @RequestParam(value = "page", required = false) Long page,
            @RequestParam(value = "size", required = false) Long size) {
        if (page == null) {
            page = 0L;
        }
        if (size == null) {
            size = 10L;
        }
        return ResponseEntity.ok(currencyService.listOfPrices(currencyName, page, size));
    }

    @GetMapping("/csv")
    public ResponseEntity csvReport() {
        currencyService.csvReport();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
