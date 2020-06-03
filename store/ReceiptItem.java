package store;

import java.util.Currency;

public class ReceiptItem {

    private double amountPerUnit;
    private int quantity;

    private Currency pricePerUnit = Currency.getInstance("RON");
    private Currency totalToPay = Currency.getInstance("RON");

    private String productName;

    public ReceiptItem() {
    }

    public ReceiptItem(double amountPerUnit, int quantity, String productName) {
        this.amountPerUnit = amountPerUnit;
        this.quantity = quantity;
        this.productName = productName;
    }

    public double getAmountPerUnit() {
        return amountPerUnit;
    }

    public void setAmountPerUnit(double amount) {
        this.amountPerUnit = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Currency getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Currency pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Currency getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(Currency totalToPay) {
        this.totalToPay = totalToPay;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
