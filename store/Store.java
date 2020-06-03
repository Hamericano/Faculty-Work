package store;

import java.util.*;

public class Store {
    private String description;
    private String name;

    private Stock storeStock;
    private Map<Integer, CashRegister> cashRegisters = new HashMap<>();
    private List<Seller> sellers = new ArrayList<>();
    private List<Administrator> admins = new ArrayList<>();

    public Store(String description, String name, Stock storeStock) {
        this.description = description;
        this.name = name;
        this.storeStock = storeStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stock getStoreStock() {
        return storeStock;
    }

    public void setStoreStock(Stock storeStock) {
        this.storeStock = storeStock;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Administrator> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Administrator> admins) {
        this.admins = admins;
    }

    public Map<Integer, CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void setCashRegisters(Map<Integer, CashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    public void addNewCashRegister(CashRegister cr, int crNo) {
        cr.setStoreName(getName());
        if (getCashRegisters().isEmpty()) {
            cashRegisters.put(crNo, cr);
        } else {
            for (Map.Entry<Integer, CashRegister> entry : cashRegisters.entrySet()) {
                CashRegister cashRegister = entry.getValue();
                int spotNumber = entry.getKey();

                if (spotNumber != crNo) {
                    cashRegisters.put(crNo, cr);
                } else {
                    System.out.println("Sorry, there is already a cash register on spot number " + crNo + " \n");
                }
                break;
            }
        }
    }

    public void addNewAdmin(EmployeeInformation employeeInformation) {
        Administrator admin = new Administrator(employeeInformation);
        this.admins.add(admin);
    }

    public void addNewSeller(EmployeeInformation employeeInformation) {
        Seller seller = new Seller(employeeInformation);
        sellers.add(seller);
    }

    public void listAllCashRegisters() {
        for (Map.Entry<Integer, CashRegister> entry : cashRegisters.entrySet()) {
            int numberOfCashRegisters = entry.getKey();
            System.out.println("Cash Register - Number " + numberOfCashRegisters);
        }
        System.out.print("\n");
    }

    public void removeCashRegister(int crNo) {
        for (Map.Entry<Integer, CashRegister> entry : cashRegisters.entrySet()) {
            if (entry.getKey().equals(crNo)) {
                cashRegisters.remove(crNo);
                System.out.println("Cash Register Number " + crNo + " has been removed! \n");
                break;
            }
        }
    }

}
