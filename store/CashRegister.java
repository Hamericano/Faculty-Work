package store;

import java.util.*;

public class CashRegister {
    private int currentReceiptNumber = 0;
    private List<Receipt> receipts = new ArrayList<>();
    private List<StockItem> productsList = new ArrayList<>();
    private boolean active;
    private String storeName;
    private String fiscalIdentifier;
    private Receipt currentReceipt;

    public CashRegister(String storeName) {
        this.storeName = storeName;
    }

    public String getFiscalIdentifier() {
        return fiscalIdentifier;
    }

    public void setFiscalIdentifier(String fiscalIdentifier) {
        this.fiscalIdentifier = fiscalIdentifier;
    }

    public List<StockItem> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<StockItem> productsList) {
        this.productsList = productsList;
    }

    public int getCurrentReceiptNumber() {
        return currentReceiptNumber;
    }

    public void setCurrentReceiptNumber(int currentReceiptNumber) {
        this.currentReceiptNumber = currentReceiptNumber;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void printCurrentReceipt() {
        if (active) {
            for (ReceiptItem item : currentReceipt.getReceiptItems()) {
                System.out.println(item.getProductName() + " " + item.getQuantity());
            }
        }
    }

    public void startNewSell() {
        if (!active) {
            Random rand = new Random();
            currentReceipt = new Receipt();
            System.out.println("Receipt no. " + this.currentReceiptNumber);
            setFiscalIdentifier(String.format("%04d", rand.nextInt(10000)));
            System.out.println(getFiscalIdentifier());
            System.out.println("--------------");
            this.currentReceiptNumber++;
            this.active = true;
        }
    }

    public void registerNewProduct(Product product, int quantity, Stock stock) {
        if (active) {
            for (StockItem item : stock.getStockItems()) {
                if (item.getProduct().getName().equalsIgnoreCase(product.getName()) && item.getQuantity() >= quantity) {
                    ReceiptItem receiptItem = new ReceiptItem(item.getProduct().getAmount(), quantity, item.getProduct().getName());
                    currentReceipt.getReceiptItems().add(receiptItem);
                    break;
                } else if (item.getProduct().getName().equalsIgnoreCase(product.getName()) && quantity > item.getQuantity()) {
                    System.out.println("Too few products !");
                    break;
                }
            }
        }
     }
//de verificat
    public void removeProductFromSell(Product product, int quantity, Stock stock) {
        if (active) {
            for (ReceiptItem item : currentReceipt.getReceiptItems()) {
                if (item.getProductName().equalsIgnoreCase(product.getName()) && item.getQuantity() > quantity) {
                    ReceiptItem receiptItem = new ReceiptItem(item.getAmountPerUnit(), item.getQuantity(), item.getProductName());
                    item.setQuantity(item.getQuantity() - quantity);
                    break;
                } else if (item.getProductName().equalsIgnoreCase(product.getName()) && item.getQuantity() == quantity) {
                    currentReceipt.getReceiptItems().remove(item);
                    break;
                }
            }
        }
    }

    public void finalizeSell(Stock stock) {
        if (active) {
            int count = 0;
            for (ReceiptItem item : currentReceipt.getReceiptItems()) {
                System.out.println((count + 1) + ". " + item.getProductName() + " - " + item.getQuantity()
                        + " / " + item.getAmountPerUnit() + item.getPricePerUnit().getCurrencyCode());
                count++;
                Product product = new Product(item.getProductName(), item.getAmountPerUnit());
                StockItem stockItem = new StockItem(product, item.getQuantity());
                stock.removeQuantityOfItem(stockItem);
            }
            System.out.println("--------------------------");
            System.out.println("Finalizing. . .");
            currentReceipt.getTotal();
            System.out.println();
            getReceipts().add(currentReceipt);

        }
        active = false;
    }

}
