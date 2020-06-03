package store;

import java.util.List;

public class Administrator {
    private EmployeeInformation employeeInformation;

    public Administrator(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public EmployeeInformation getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }


    public void addProductsToStock(List<StockItem> productsToAdd, Stock stock) {
        for (StockItem stockItem : productsToAdd) {
            stock.getStockItems().add(stockItem);
        }
    }

    public void checkProductsStock(List<StockItem> productsToCheck, Stock stock) {
        for (StockItem item : productsToCheck) {
            for (StockItem stockItem : stock.getStockItems()) {

                if (item.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName())) {
                    System.out.println(item.getProduct().getName() + " STOCK: " + stockItem.getQuantity());
                } else {
                    System.out.println("The product " + stockItem.getProduct().getName() + " is not in the stock.");
                }
            }
        }
    }

    public void removeProductFromStock(String name, Stock stock) {
        for(int i = 0; i < stock.getStockItems().size(); i++){
            StockItem item = stock.getStockItems().get(i);
            if (item.getProduct().getName().equalsIgnoreCase(name)) {
                stock.getStockItems().remove(item);
                System.out.println(item.getProduct().getName() + " has been removed from stock.\n");
            }
        }
    }

    public void addProductToStock(StockItem item, Stock stock) {
        stock.getStockItems().add(item);
    }

    public void printStock(Stock stock) {
        for (StockItem item : stock.getStockItems()) {
            System.out.println("PRODUCT: " + item.getProduct().getName() + " | QUANTITY: " + item.getQuantity() + "\n");
        }
    }
}
