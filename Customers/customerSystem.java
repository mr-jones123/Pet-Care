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
        System.out.println("ENTER YOUR INFORMATION");
        System.out.println();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter your Name: ");
                this.name = scan.nextLine();
                while (this.name.trim().isEmpty()) {
                    System.out.print("Name cannot be empty. Please enter your Name: ");
                    this.name = scan.nextLine();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Character! Please try again.");
            }
        }
        customerCode = customerCode + 1;
        System.out.println("PLEASE REMEMBER YOUR CUSTOMER CODE!");
        System.out.println();
        System.out.printf("Customer Name: %s \n", name);
        System.out.printf("Customer Code: %d \n", customerCode);
        System.out.println();
        customers.put(name, customerCode);
        queueSystem.addCustomer(new customer(name, customerCode));
        
    }
    public void printCustomers() {
        System.out.println("TOP TO BOTTOM");
        System.out.println();
        if (isItEmpty()) {
            System.out.println("NO ONE HAS REGISTERED YET");
        } else {
            for (Map.Entry<String, Integer> entries : customers.entrySet()) {
                System.out.printf("Customer Name: %s\n", entries.getKey());
                System.out.printf("Customer Code: %d\n", entries.getValue());
                System.out.println();
            }
        }
    }

    public boolean isItEmpty() {
        return customers.isEmpty();
    }
    public void printCurrentCustomer() {
        customer currentCustomer = queueSystem.getCurrentCustomer();
        if (currentCustomer != null) {
            System.out.println("\t \t \t \tCurrent customer name: " + currentCustomer.getCustomerName());
            System.out.println("\t \t \t \tCurrent customer ID: " + currentCustomer.getCustomerID());
        } else {
            System.out.println("No current customer.");
        }
    }
    public HashMap<String, Integer> getRegisteredCustomers() {
        return customers;
    }
    
}
