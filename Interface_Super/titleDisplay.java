package Interface_Super;

public class titleDisplay {

    public void TITLEDISPLAY(){
        clearScreen();
        System.out.println("\t\t\t\r\n" + //
                        "▒█░░▒█ █▀▀ █░░ █▀▀ █▀▀█ █▀▄▀█ █▀▀ 　 ▀▀█▀▀ █▀▀█ 　 ▒█▀▄▀█ █▀▀ █▀▀▄ ░▀░ ▒█▀▀█ █▀▀ ▀▀█▀▀ \r\n" + //
                        "▒█▒█▒█ █▀▀ █░░ █░░ █░░█ █░▀░█ █▀▀ 　 ░░█░░ █░░█ 　 ▒█▒█▒█ █▀▀ █░░█ ▀█▀ ▒█▄▄█ █▀▀ ░░█░░ \r\n" + //
                        "▒█▄▀▄█ ▀▀▀ ▀▀▀ ▀▀▀ ▀▀▀▀ ▀░░░▀ ▀▀▀ 　 ░░▀░░ ▀▀▀▀ 　 ▒█░░▒█ ▀▀▀ ▀▀▀░ ▀▀▀ ▒█░░░ ▀▀▀ ░░▀░░");
        System.out.println();
        System.out.flush();
        pressEnterToContinue();        
    }
    private void pressEnterToContinue() {
        System.out.println("\t\t\tPRESS ENTER TO CONTINUE.");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }   
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
