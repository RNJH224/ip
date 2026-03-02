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

    public static void main(String[] args) {
        new NoNeck("data/duke.txt").run();
    }
}