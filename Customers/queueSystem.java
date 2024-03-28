package Customers;
import java.util.Queue;

import Customers.customerSystem.customer;

import java.util.LinkedList;
public class queueSystem {
    private static Queue <customer> listOfCustomers = new LinkedList<>();

    public void addCustomer(customer Customer){
        listOfCustomers.add(Customer);
    }
    public customer removeFirst(){
        customer removedCustomer = listOfCustomers.poll();
        return removedCustomer;
    }    
    public int isInQueue(int customerCode){
        customer head = listOfCustomers.peek();
        if (head != null && head.getCustomerID() == customerCode) {
            return 1; // customer is at the head of the queue
        }
        for (customer c: listOfCustomers){
            if (c.getCustomerID() == customerCode){
                return 2; // customer is in the queue but not at the head
            }
        }
        return 0; // customer is not in the queue
    }
    public customer getCurrentCustomer() {
        return listOfCustomers.peek();
    }
    
    // public Queue<Integer> getQueue(){
    //     return new LinkedList<>(customerID);
    // }


}
