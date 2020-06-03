package market;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    private double totalToPay;
    private int count;
    private Map<Product, Integer> receipt = new HashMap<>();

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<Product, Integer> getReceipt() {
        return receipt;
    }

    public void setReceipt(Map<Product, Integer> receipt) {
        this.receipt = receipt;
    }

    public void printReceipt(){
        totalToPay = 0.0;
        System.out.println("-----------------------");
        for (Map.Entry<Product, Integer> store : receipt.entrySet()) {
            Product product = store.getKey();
            int value = store.getValue();
            System.out.println(value + " \tx\t" + product.getName() + "\t" + product.getPrice() + " $ ");
            totalToPay = totalToPay + product.getPrice() * value;
            this.count = this.count + value;
        }
        System.out.println("-----------------------");
        System.out.println(this.count + " total products paid.");
        System.out.println("TOTAL : " + totalToPay + " $");
        System.out.println("-----------------------");
    }
}
