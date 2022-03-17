package co.oril.util;

import co.oril.dto.PriceDTO;
import co.oril.model.Currency;
import com.google.gson.Gson;

import java.util.List;

public final class Json {

    private Json() {
    }

    public static String priceToJson(Double price) {
        Gson gson = new Gson();
        PriceDTO dto = new PriceDTO(price);
        return gson.toJson(dto);
    }

    public static String listToJson(List<Currency> currencies) {
        Gson gson = new Gson();
        return gson.toJson(currencies);
    }
}
