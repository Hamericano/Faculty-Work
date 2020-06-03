package store;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<StockItem> stockItems = new ArrayList<>();

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }

    public void addStock(StockItem stockItem) {
        boolean isInStock = false;
        for (StockItem item : getStockItems()) {
            if (item.getProduct().getName().equalsIgnoreCase(stockItem.getProduct().getName())) {
                isInStock = true;
                item.setQuantity(item.getQuantity() + stockItem.getQuantity());
                System.out.println("The quantity of " + item.getProduct().getName() + " has been updated. \n");
            }
        }
        if(!isInStock) {
            stockItems.add(stockItem);
            System.out.println(stockItem.getQuantity() + " " + stockItem.getProduct().getDescription() + " " +
                    stockItem.getProduct().getName() + " have been added to the market stock.\n");
        }
    }

    public void removeQuantityOfItem(StockItem stockItem) {
        for (int i = 0; i < getStockItems().size(); i++){
            StockItem item = getStockItems().get(i);
            if (stockItem.getProduct().getName().equalsIgnoreCase(item.getProduct().getName()) && item.getQuantity() > stockItem.getQuantity()) {
                item.setQuantity(item.getQuantity() - stockItem.getQuantity());
                System.out.println("The " + item.getProduct().getName() + " stock has been substracted with " + stockItem.getQuantity() + ".\n");
                break;
            } else if(stockItem.getProduct().getName().equalsIgnoreCase(item.getProduct().getName()) && item.getQuantity() < stockItem.getQuantity()){
                stockItems.remove(item);
                break;
            }
        }
    }

    public void updateProductPrice(StockItem stockItem, int amount) {
        for (StockItem item : stockItems) {

            if (stockItem.getProduct().getName().equalsIgnoreCase(item.getProduct().getName())) {
                stockItem.getProduct().setAmount(amount);
                System.out.println("The price of " + stockItem.getProduct().getName() + " was updated to " + amount + " " + stockItem.getProduct().getPrice().getCurrencyCode());
            } else {
                System.out.println("Product " + stockItem.getProduct().getName() + " is not in stock.");
            }
            break;
        }
    }
}
