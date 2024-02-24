package Interface_Super;
import java.util.HashMap;
public interface interfaceClass {
    public void pay(HashMap<String, Integer> services);
    public  void mainMenu();
    public void amountChecker(String service, int amount, HashMap<String, Integer> services);
    public void clearScreen();
    public void printReceipt(String service, int amount, int change);
    public void printDescription();
}
