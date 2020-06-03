package store;

import java.util.Currency;

public class Product {

    private String name;
    private String description;
    private double amount;
    private Currency price = Currency.getInstance("RON");

    public Product(String name, String description, double amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getPrice() {
        return price;
    }
}
