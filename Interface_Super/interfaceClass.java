package Interface_Super;
import java.util.HashMap;
public interface interfaceClass {
    public int selectionOfService(HashMap<Integer, Integer> services);
    public  void mainMenu();
    public void clearScreen();
    public void printDescription();
    public void addServiceCheckout(int serviceNumber,HashMap<Integer, Integer> services, HashMap<String, Integer> listOfServices);
}
