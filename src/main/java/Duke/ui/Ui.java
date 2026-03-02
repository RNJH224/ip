package Duke.ui;

import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void showWelcome(String name) {
        System.out.println("Hello i'm " + name);
        System.out.println("what can i do for you");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("Sorry i don't understand");
    }

    public void showBye() {
        System.out.println("Astalavista Baby!");
    }
}
