package co.oril.util;

import co.oril.model.Currency;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public final class CSV {

    private CSV() {
    }

    private static final String SEPARATOR = ",";

    public static void writeStringToCSVFile(String path, String stringToWrite) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path, true);
            fileWriter.write(stringToWrite + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в CSV файл");
        }
    }

    public static void cleanCSVFile(String path) {
        String header = "Currency name, Min price, Max price\n";
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(header);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при очистке CSV файла");
        }
    }

    public static String createLineFromList(List<Currency> currencies) {
        StringBuilder newLine = new StringBuilder();
        Double minPrice = FindMinAndMaxPrice.findMinPrice(currencies);
        Double maxPrice = FindMinAndMaxPrice.findMaxPrice(currencies);
        newLine.append(currencies.get(0).getCurrencyName()).append(SEPARATOR);
        newLine.append(minPrice).append(SEPARATOR);
        newLine.append(maxPrice);
        return newLine.toString();
    }
}
