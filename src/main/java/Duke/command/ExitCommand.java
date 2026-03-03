package Duke.command;

import Duke.storage.Storage;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

/**
 * Represents a command that exits the application.
 */
public class ExitCommand extends Command {
    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) {
        ui.showBye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}