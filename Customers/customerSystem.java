package Customers;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;

public class customerSystem {
    private String name;
    private int customerCode = 0;
    private HashMap<String, Integer> customers = new HashMap<>();
    Scanner scan = new Scanner(System.in);

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
        queueSystem queueSystem = new queueSystem();
        queueSystem.addCustomerToQueue(this.customerCode);
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

    public HashMap<String, Integer> getCustomers() {
        return customers;
    }

}
