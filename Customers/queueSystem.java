package Customers;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
public class queueSystem {
    private customerSystem Customer = new customerSystem();

    private static Queue <Integer> customerID = new LinkedList<>();
    private HashMap <String, Integer> customers = new HashMap<>(Customer.getCustomers());   

    public void addCustomerToQueue(int customerCode){
        customerID.add(customerCode);
    }
   
    public void printQueue(){
        if (customerID.isEmpty()){
            System.out.println("Nobody's here yet!");
        } else{
            for (Integer customer : customerID){
                System.out.print(customer + " ");
            }
        }
    }
    public void removeFirst(){
        customerID.poll();
    }    
    public int isInQueue(int customerCode){
        if (customerID.contains(customerCode)) {
            if (priorityCheck(customerCode)) { // if the customer code is in first index
                return 2;
            } else { //if customer code is in the queue but not at the first index
                return 1;
            }
        }
        return 0;
    }

    public boolean priorityCheck(int customerCode){
        int priorityCustomerNumber = customerID.peek();
        if (priorityCustomerNumber == customerCode){
            return true;
        }
        return false;
    }

    public Queue<Integer> getQueue(){
        return new LinkedList<>(customerID);
    }


}
