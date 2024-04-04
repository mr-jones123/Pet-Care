package Customers;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;
public class customerSystem {
    private String name;
    private int customerCode = 0;
    private HashMap<String, Integer> customers = new HashMap<>();
    queueSystem queueSystem = new queueSystem();
    Scanner scan = new Scanner(System.in);
    public class customer{
        private String customerName;
        private int customerID = 0;
        public customer(String customerName, int customerID){
            this.customerName = customerName;
            this.customerID = customerID;
        }
        @Override
        public String toString(){
            return "Customer Name: " + customerName + " " + "Customer ID: " + customerID;
        }
        public int getCustomerID(){
            return customerID;
        }
        public String getCustomerName(){
            return customerName;
        }
    }

    public void registerCustomer() {
        System.out.println("\t\t\tENTER YOUR INFORMATION");
        System.out.println();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("\t\t\tEnter your Name: ");
                this.name = scan.nextLine();
                while (this.name.trim().isEmpty()) {
                    System.out.print("\t\t\tName cannot be empty. Please enter your Name: ");
                    this.name = scan.nextLine();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Character! Please try again.");
            }
        }
        customerCode = customerCode + 1;
        System.out.println("\t\t\tPLEASE REMEMBER YOUR CUSTOMER CODE!");
        System.out.println();
        System.out.printf("\t\t\tCustomer Name: %s \n", name);
        System.out.printf("\t\t\tCustomer Code: %d \n", customerCode);
        System.out.println();
        customers.put(name, customerCode);
        queueSystem.addCustomer(new customer(name, customerCode));
        
    }
    public int getCustomerID(){
        return customerCode;
    }
    public String getCustomerName(){
        return name;
    }
    
    public void printCustomers() {   
        System.out.println();
        if (isItEmpty()) {
            System.out.println("\t\t\tNO ONE HAS REGISTERED YET");
        } else {
            for (Map.Entry<String, Integer> entries : customers.entrySet()) {
                System.out.printf("\t\t\tName: %s\n", entries.getKey());
                System.out.printf("\t\t\tCode: %d\n", entries.getValue());
                System.out.println();
            }
        }
    }

    public boolean isItEmpty() {
        return customers.isEmpty();
    }
    public void removeOnMap(String customerName){
        customers.remove(customerName);
    }

    public void printCurrentCustomer() {
        customer currentCustomer = queueSystem.getCurrentCustomer();
        if (currentCustomer != null) {
            System.out.println("\t \t \t \tCustomer Name: " + currentCustomer.getCustomerName());
            System.out.println("\t \t \t \tCustomer ID: " + currentCustomer.getCustomerID());
        } else {
            System.out.println("\t\t\tNo current customer.");
        }
    }
    public HashMap<String, Integer> getRegisteredCustomers() {
        return customers;
    }
    
}
