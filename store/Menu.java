package store;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Menu {
    private EmployeeInformation employeeInformation;
    private Store store;
    private Seller seller;
    private Administrator admin;
    private int cashRegisterChoice;

    public Menu(Store store) {
        this.store = store;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public EmployeeInformation getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(EmployeeInformation employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

    public int getCashRegisterChoice() {
        return cashRegisterChoice;
    }

    public void setCashRegisterChoice(int cashRegisterChoice) {
        this.cashRegisterChoice = cashRegisterChoice;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    Scanner scanner = new Scanner(System.in);


    public void showMainMenu() {
        System.out.println("");
        System.out.println("Store Menu");
        System.out.println("---------------------------");
        System.out.println("0. Exit the program");
        System.out.println("1. Enter as Administrator.");
        System.out.println("2. Enter as Seller.");
        System.out.println("----------------------------");
        System.out.println("");
        System.out.print("Please select an option from 0-2");
        System.out.println("");
        System.out.println("");
    }

    public void printMenu(Store store) {
        showMainMenu();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.store = store;
            int selectedOption = Integer.parseInt(bufferedReader.readLine());
            switch (selectedOption) {
                case 0: {
                    quitProgram();
                    break;
                }
                case 1: {
                    showSubMenuOptions(1);
                    break;
                }
                case 2: {
                    showSubMenuOptions(2);
                    break;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error!" + exception);
            System.exit(1);
        }
    }

    public void showSubMenuOptions(int mainMenuChoice) {
        switch (mainMenuChoice) {
            case 1:
                new AdminOptions();
                this.store.addNewAdmin(this.employeeInformation);
                break;
            case 2:
                new SellerOptions();
                this.store.addNewSeller(this.employeeInformation);
                break;
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int selectedOption = Integer.parseInt(bufferedReader.readLine());
            switch (selectedOption) {
                case 0: {
                    printMenu(store);
                    break;
                }
                case 1: {
                    if (mainMenuChoice == 1) {
                        showAdminSubMenu(1);
                    } else if (mainMenuChoice == 2) {
                        this.store.listAllCashRegisters();
                        System.out.println("Which cash register would you like to operate ?");
                        setCashRegisterChoice(scanner.nextInt());
                        this.store.getCashRegisters().get(getCashRegisterChoice()).startNewSell();
                        showSellerSubMenu();
                    }
                    break;
                }
                case 2: {
                    if (mainMenuChoice == 1) {
                        showAdminSubMenu(2);
                    } else if (mainMenuChoice == 2) {
                        store.getSellers().get(0).searchProduct(scanner.next(), store.getStoreStock());
                        showSubMenuOptions(2);
                    }
                    break;
                }
                case 3: {
                    if (mainMenuChoice == 2) {
                        store.getSellers().get(0).printStock(this.store.getStoreStock());
                        showSubMenuOptions(2);
                    }
                    break;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error!" + exception);
            System.exit(1);
        }
    }

    public void showSellerSubMenu() {
        System.out.println("Start Sell Options");
        System.out.println("--------------------------");
        System.out.println("1. Add Product to Sell");
        System.out.println("2. Remove Product");
        System.out.println("3. View Current Sell");
        System.out.println("4. Finalize Sell");
        System.out.println("--------------------------");
        System.out.println("0. Back");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int selectedOption = Integer.parseInt(bufferedReader.readLine());
            switch (selectedOption) {
                case 0: {
                    showSubMenuOptions(2);
                    break;
                }
                case 1: {
                    this.store.getSellers().get(0).printStock(this.store.getStoreStock());
                    System.out.println("What product do you wish to buy ?");
                    Product product = new Product();
                    product.setName(scanner.next());
                    System.out.println("How many ?");
                    int quantity = scanner.nextInt();
                    this.store.getCashRegisters().get(getCashRegisterChoice()).
                            registerNewProduct(product, quantity, this.store.getStoreStock());
                    showSellerSubMenu();
                    break;
                }
                case 2: {
                    Product product = new Product();
                    product.setName(scanner.next());
                    System.out.println("How many ?");
                    int quantity = scanner.nextInt();
                    this.store.getCashRegisters().get(getCashRegisterChoice()).
                            removeProductFromSell(product, quantity, this.store.getStoreStock());
                    this.store.getSellers().get(0).
                            returnProduct(product, quantity, this.store.getStoreStock());
                    showSellerSubMenu();
                    break;
                }
                case 3: {
                    System.out.println();
                    this.store.getCashRegisters().get(getCashRegisterChoice()).printCurrentReceipt();
                    showSellerSubMenu();
                    break;
                }
                case 4: {
                    System.out.println();
                    this.store.getCashRegisters().get(getCashRegisterChoice()).finalizeSell(this.store.getStoreStock());
                    showSellerSubMenu();
                    break;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error! " + exception);
            System.exit(1);
        }
    }

    public void showAdminSubMenu(int showAdminSubMenuChoice) {
        switch (showAdminSubMenuChoice) {
            case 1: {
                showAdminStockOptions();
                break;
            }
            case 2: {
                showAdminCashRegistersOptions();
                break;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int selectedOption = Integer.parseInt(bufferedReader.readLine());
            switch (selectedOption) {
                case 0: {
                    showSubMenuOptions(1);
                    break;
                }
                case 1: {
                    if (showAdminSubMenuChoice == 1) {
                        Product product = new Product();
                        System.out.print("Name: ");
                        product.setName(scanner.next());
                        System.out.print("Description: ");
                        product.setDescription(scanner.next());
                        System.out.print("Price: ");
                        product.setAmount(scanner.nextInt());
                        System.out.print("Quantity: ");
                        StockItem item = new StockItem(product, scanner.nextInt());
                        this.store.getAdmins().get(0).addProductToStock(item, this.store.getStoreStock());
                        showAdminSubMenu(1);
                    } else if (showAdminSubMenuChoice == 2) {
                        CashRegister cashRegister = new CashRegister(this.store.getName());
                        System.out.println("Enter the number of the cash register: ");
                        int number = scanner.nextInt();
                        this.store.addNewCashRegister(cashRegister, number);
                        System.out.println();
                        showAdminSubMenu(2);
                    }
                    break;
                }
                case 2: {
                    if (showAdminSubMenuChoice == 1) {
                        System.out.println("What product do you wish to remove ?");
                        this.store.getAdmins().get(0).removeProductFromStock(scanner.next(), this.store.getStoreStock());
                        showAdminSubMenu(1);
                    } else if (showAdminSubMenuChoice == 2) {
                        System.out.println("What cash register do you wish to remove ?");
                        this.store.removeCashRegister(scanner.nextInt());
                        showAdminSubMenu(2);
                    }
                    break;
                }
                case 3: {
                    if (showAdminSubMenuChoice == 1) {
                        this.store.getAdmins().get(0).printStock(this.store.getStoreStock());
                        showAdminSubMenu(1);
                    } else if (showAdminSubMenuChoice == 2) {
                        this.store.listAllCashRegisters();
                        showAdminSubMenu(2);
                    }
                    break;
                }
            }
        } catch (IOException exception) {
            System.out.println("Error! " + exception);
            System.exit(1);
        }
    }

    public void quitProgram() {
        System.out.println("You have quit the program");
        System.exit(0);
    }

    public void showAdminCashRegistersOptions() {
        System.out.println("Cash Registers Options");
        System.out.println("--------------------------");
        System.out.println("1. Add Cash Register.");
        System.out.println("2. Remove Cash Register.");
        System.out.println("3. View Cash Registers.");
        System.out.println("--------------------------");
        System.out.println("0. Back.");
        System.out.println("");
    }

    public void showAdminStockOptions() {
        System.out.println("Stock Options");
        System.out.println("--------------------------");
        System.out.println("1. Add Product.");
        System.out.println("2. Remove Product.");
        System.out.println("3. View Stock.");
        System.out.println("--------------------------");
        System.out.println("0. Back.");
        System.out.println("");
    }
    public static void main(String[] args) {
        Stock stock = new Stock();
        Product product = new Product("Apples", "Fresh", 15);
        StockItem item = new StockItem(product, 12);
        stock.addStock(item);
        Store store = new Store("Cel mai aproape de tine !", "Kaufland", stock);
        Menu menu = new Menu(store);
        EmployeeInformation employeeInformation = new EmployeeInformation("Gigel", "075324122","Strada Nemuririi Nr. 20");
        store.addNewSeller(employeeInformation);
        menu.printMenu(store);

    }
}
