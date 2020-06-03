package market;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {
    Scanner scanner = new Scanner(System.in);
    private Map<Product, Integer> marketStock = new HashMap<>();
    private Receipt receipt = new Receipt();


    public void addStock(Product product, int value) {
        marketStock.put(product, value);
        System.out.println(value + " " + product.getDescription() + " "  + product.getName() + " have been added to the market stock.\n");
    }

    public void supplyStock(String name, int number) {
        for (Map.Entry<Product, Integer> entry : marketStock.entrySet()) {
            Product product = entry.getKey();
            int value = entry.getValue();

            if (product.getName().equalsIgnoreCase(name) && value != 0) {
                marketStock.replace(product, value + number);
                System.out.println("The " + product.getName() + " stock has been supplied with " + number + "\n");
            }
        }
    }

    public void handReceipt() {
        receipt.printReceipt();
    }

    public void findProductInStock(String name) {
        for (Map.Entry<Product, Integer> stock : marketStock.entrySet()) {
            Product product = stock.getKey();
            int value = stock.getValue();

            if (name.equalsIgnoreCase(product.getName())) {
                System.out.println("We have " + value + " x " + product.getName() + " in stock.\n");
            }
        }
    }


    public void addProductToReceipt(String name, int quantity) {
        for (Map.Entry<Product, Integer> stock : marketStock.entrySet()) {
            Product product = stock.getKey();
            int value = stock.getValue();
            if (name.equalsIgnoreCase(product.getName()) && value == quantity) {
                receipt.getReceipt().put(product, quantity);
                marketStock.remove(product);
                break;
            }
            if (name.equalsIgnoreCase(product.getName()) && value > quantity) {
                receipt.getReceipt().put(product, quantity);
                marketStock.replace(product, value - quantity);
                break;
            }
        }
    }

    public void printStock() {
        System.out.println("\t\tSTOCK \n-----------------------------");
        for (Map.Entry<Product, Integer> entry : marketStock.entrySet()) {
            Product product = entry.getKey();
            int value = entry.getValue();

            System.out.println(product.getDescription() + " " + product.getName() + " - " + value + "\t" + product.getPrice() + " $ / each");
        }
        System.out.println("-----------------------------\n");
    }

    public void addProduct() {
        Product product = new Product();
        System.out.print("Product name ");
        product.setName(scanner.next());
        System.out.print("Product description ");
        product.setDescription(scanner.next());
        System.out.print("Product price ");
        product.setPrice(scanner.nextDouble());
        System.out.println("How many " + product.getName() + " you wish to add? ");
        int quantity = scanner.nextInt();
        addStock(product, quantity);
    }
}
