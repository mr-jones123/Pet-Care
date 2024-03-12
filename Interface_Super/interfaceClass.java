package Interface_Super;
import java.util.HashMap;
public interface interfaceClass {
    public void pay(HashMap<Integer, Integer> services);
    public  void mainMenu();
    public void amountChecker(int service, int amount, HashMap<Integer, Integer> services);
    public void clearScreen();
    public void printReceipt(int service, int amount, int change);
    public void printDescription();
}
