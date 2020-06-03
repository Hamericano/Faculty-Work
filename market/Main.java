package market;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SellerEmployee sellerEmployee = new SellerEmployee(56, "Octavian");
        do{
            System.out.println("0.Exit \n1.Add product stock. \n2.Supply stock. \n3.Search product. " +
                    "\n4.Print receipt. \n5.Purchase product. \n6.Print stock.\n");
            int option = scanner.nextInt();

            switch(option){
                case 0:{
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                }
                case 1:{
                    scanner.nextLine();
                    sellerEmployee.addProduct();
                    break;
                }
                case 2:{
                    System.out.println("What stock you wish to supply?\n");
                    sellerEmployee.printStock();
                    String choice = scanner.next();
                    System.out.print("How many ? ");
                    int number = scanner.nextInt();
                    sellerEmployee.supplyStock(choice, number);
                    break;
                }
                case 3:{
                    System.out.println("What product are you looking for ? ");
                    String nameProduct = scanner.next();
                    sellerEmployee.findProductInStock(nameProduct);
                    break;
                }
                case 4:{
                    sellerEmployee.handReceipt();
                    break;
                }
                case 5:{
                    System.out.println("What do you wish to buy ? ");
                    String nameProduct = scanner.next();
                    System.out.println("How many ?");
                    int quantity = scanner.nextInt();
                    sellerEmployee.addProductToReceipt(nameProduct, quantity);
                    break;
                }
                case 6:{
                    sellerEmployee.printStock();
                    break;
                }
            }
        }while(true);
    }
}
