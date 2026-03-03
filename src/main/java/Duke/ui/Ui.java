package Duke.ui;

import java.util.Scanner;

/**
 * Handles all user interactions for the NoNeck application.
 * <p>
 * Responsible for displaying messages and reading user input
 * from the command line.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays the welcome message when the application starts.
     *
     * @param name Name of the application.
     */
    public void showWelcome(String name) {
        System.out.println("Hello i'm " + name);
        System.out.println("what can i do for you");
    }

    /**
     * Reads a full command line from the user.
     *
     * @return The user's input as a String.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Displays a loading error message when saved data
     * cannot be read properly.
     */
    public void showLoadingError() {
        System.out.println("Sorry i don't understand");
    }

    /**
     * Displays the goodbye message when the application exits.
     */
    public void showBye() {
        System.out.println("Astalavista Baby!");
    }
}
