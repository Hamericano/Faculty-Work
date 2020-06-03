package store;

import java.util.List;

public class Seller {
    private EmployeeInformation employeeInformation;

    public Seller() {
    }

    public Seller(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public EmployeeInformation getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public void searchProduct(String name, Stock stock) {
        for (StockItem item : stock.getStockItems()) {
            if (item.getProduct().getName().equalsIgnoreCase(name)) {
                System.out.println("PRODUCT: " + item.getProduct().getName() + "| QUANTITY: " + item.getQuantity() + " \n");
                break;
            }
        }
    }

    public boolean checkProductStock(StockItem stockItem, Stock stock) {
        for (StockItem item : stock.getStockItems()) {
            if (stockItem.getProduct().getName().equalsIgnoreCase(item.getProduct().getName())) {
                return true;
            }
        }
        return false;
    }

    public void returnProduct(Product product, int quantity, Stock stock) {
        for (StockItem item : stock.getStockItems()) {
            StockItem stockItem = new StockItem(product, quantity);
            stock.addStock(stockItem);
        }
    }

    public void removeProductsFromStock(Stock stock, List<ReceiptItem> productsToRemove) {
        for(ReceiptItem receiptItem : productsToRemove) {
            Product product = new Product(receiptItem.getProductName(), receiptItem.getAmountPerUnit());
            StockItem stockItem = new StockItem(product, receiptItem.getQuantity());
            stock.removeQuantityOfItem(stockItem);
        }
    }

    public void printStock(Stock stock) {
        for (int i = 0; i < stock.getStockItems().size(); i++) {
            StockItem item = stock.getStockItems().get(i);
            System.out.println("PRODUCT: " + item.getProduct().getName() + " | QUANTITY: " + item.getQuantity() + "\n");
        }
    }
}
