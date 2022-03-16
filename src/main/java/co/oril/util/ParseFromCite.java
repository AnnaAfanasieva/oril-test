package co.oril.util;

import co.oril.dto.CurrencyDTO;
import co.oril.model.Currency;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

public final class ParseFromCite {

    public static final String BTC_URL = "https://cex.io/api/ticker/BTC/USD";
    public static final String ETH_URL = "https://cex.io/api/ticker/ETH/USD";
    public static final String XRP_URL = "https://cex.io/api/ticker/XRP/USD";

    private ParseFromCite() {
    }

    public static String stringFromCite(String currencyUrl) {
        URL obj;
        try {
            obj = new URL(currencyUrl);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CurrencyDTO dtoFromString(String stringFromCite) {
        Gson gson = new Gson();
        return gson.fromJson(stringFromCite, CurrencyDTO.class);
    }

    public static Currency modelFromDto(CurrencyDTO dto) {
        Pattern pattern = Pattern.compile(":");
        String[] currencyName = pattern.split(dto.pair);
        Double price = Double.parseDouble(dto.last);
        return new Currency(currencyName[0], price);
    }

    public static Currency currencyFromCite(String currencyUrl) {
        String stringFromCite = stringFromCite(currencyUrl);
        CurrencyDTO dto = dtoFromString(stringFromCite);
        return modelFromDto(dto);
    }
}
