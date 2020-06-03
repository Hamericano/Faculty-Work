package store;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> receiptItems = new ArrayList<>();

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public void getTotal() {
        ReceiptItem item = new ReceiptItem();
        double total = 0.0;
        for (ReceiptItem receiptItem : getReceiptItems()) {
            total += receiptItem.getQuantity() * receiptItem.getAmountPerUnit();
        }
        System.out.println("TOTAL TO PAY: " + total + item.getTotalToPay().getCurrencyCode());
    }

    public void getTotalForProduct(ReceiptItem item) {
        double totalToPayForProduct = 0.0;
        for (ReceiptItem receiptItem : getReceiptItems()) {
            if(receiptItem.getProductName().equalsIgnoreCase(item.getProductName())) {
                totalToPayForProduct += receiptItem.getQuantity() * receiptItem.getAmountPerUnit();
            }
        }
        System.out.println("Total to pay for " + item.getProductName() + totalToPayForProduct + " " + item.getTotalToPay().getCurrencyCode());
    }

}
