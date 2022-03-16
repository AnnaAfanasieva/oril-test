package co.oril.model;

import co.oril.util.GenerateId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("currency")
public class Currency {

    @Id
    private String id;

    @Field(name = "name")
    private String currencyName;

    @Field(name = "price")
    private Double currencyPrice;

    public Currency(String currencyName, Double currencyPrice) {
        this.id = GenerateId.getGeneratedId();
        this.currencyName = currencyName;
        this.currencyPrice = currencyPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(Double currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currencyPrice=" + currencyPrice +
                '}';
    }
}
