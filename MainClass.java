import Interface_Super.*;
import Shops.*;
public class MainClass {
    public static void main(String[] args) throws Exception {
        MenuDisplay menuDisplay = new MenuDisplay();
        titleDisplay TitleDisplay = new titleDisplay();
        TitleDisplay.TITLEDISPLAY();
        menuDisplay.registrationDisplay();
    }
}
