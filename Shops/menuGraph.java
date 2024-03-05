package Shops;
import java.util.*;
// HAVENT TESTED YET.
public class menuGraph {
    int ch;
    initializeGraph Graph = new initializeGraph();
    Scanner scan = new Scanner(System.in);
    public void shopMenu(){
        System.out.println("WHERE ARE YOU IN THESE AREAS?");
        System.out.println();
        System.out.println("1. Manila");
        System.out.println("2. Makati");
        System.out.println("3. Taguig");
        System.out.println("4. Mandaluyong");
        System.out.println("5. Marikina");
        do {
            try {
                ch = scan.nextInt();
                switch (ch) {
                    case 1:
                        //STARTS IN MANILA
                        break;
                    case 2:
                        //STARTS IN MAKATI
                        break;
                    case 3:
                        //STARTS IN TAGUIG
                        break;
                    case 4: 
                        //STARTS IN MANDALUYONG
                        break;
                    case 5:
                        //STARTS IN MARIKINA
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("INVALID CHARACTER");
                
            }
        } while (ch != 0);
    }
  
}
