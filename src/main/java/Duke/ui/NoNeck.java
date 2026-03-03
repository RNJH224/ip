package Duke.ui;

import Duke.command.Command;
import Duke.parser.Parser;
import Duke.storage.Storage;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;


public class NoNeck {

    private final Storage storage;
    private final Tasklist tasks;
    private final Ui ui;

    /**
     * Constructs a NoNeck application with the given file path.
     * Attempts to load existing tasks from storage. If loading fails,
     * an empty task list is created instead.
     *
     * @param filePath Path to the data file used for saving and loading tasks.
     */
    public NoNeck(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);

        Tasklist loadedTasks;
        try {
            loadedTasks = new Tasklist(storage.load());
        } catch (IOException e) {
            ui.showLoadingError();
            loadedTasks = new Tasklist();
        }

        tasks = loadedTasks;
    }

    /**
     * starts the main execution loop of the application
     * it will continue to run until a exitcommand is used results in isexit to be true exiting the loop
     */
    public void run() {
        ui.showWelcome("NoNeck");

        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();

                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);

                isExit = c.isExit();

            } catch (IOException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Main method that launches the NoNeck application.
     *
     * @param args
     */
    public static void main(String[] args) {
        new NoNeck("data/duke.txt").run();
    }
}