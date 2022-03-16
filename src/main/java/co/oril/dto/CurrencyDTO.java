package co.oril.dto;

public class CurrencyDTO {

    public String timestamp;
    public String low;
    public String high;
    public String last;
    public String volume;
    public String volume30d;
    public double bid;
    public double ask;
    public String priceChange;
    public String priceChangePercentage;
    public String pair;

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "timestamp='" + timestamp + '\'' +
                ", low='" + low + '\'' +
                ", high='" + high + '\'' +
                ", last='" + last + '\'' +
                ", volume='" + volume + '\'' +
                ", volume30d='" + volume30d + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", priceChange='" + priceChange + '\'' +
                ", priceChangePercentage='" + priceChangePercentage + '\'' +
                ", pair='" + pair + '\'' +
                '}';
    }
}
