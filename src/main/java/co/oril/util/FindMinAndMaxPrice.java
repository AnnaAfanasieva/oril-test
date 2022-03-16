package co.oril.util;

import co.oril.model.Currency;

import java.util.ArrayList;
import java.util.List;

public final class FindMinAndMaxPrice {

    private FindMinAndMaxPrice() {
    }

    public static List<Double> priceListFromCurrencyList(List<Currency> currencies) {
        List<Double> prices = new ArrayList<>();
        for (Currency currency : currencies) {
            prices.add(currency.getCurrencyPrice());
        }
        return prices;
    }

    public static Double findMinPrice(List<Currency> currencies) {
        List<Double> prices = priceListFromCurrencyList(currencies);
        return prices.stream().mapToDouble(v -> v).min().getAsDouble();
    }

    public static Double findMaxPrice(List<Currency> currencies) {
        List<Double> prices = priceListFromCurrencyList(currencies);
        return prices.stream().mapToDouble(v -> v).max().getAsDouble();
    }
}
