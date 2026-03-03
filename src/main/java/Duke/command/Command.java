package Duke.command;

import Duke.storage.Storage;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;

/**
 * Represents a generic command that can be executed in the NoNeck application.
 * <p>
 * Each concrete command defines its own execution behaviour.
 */
public abstract class Command {

    /**
     * Executes the command.
     *
     * @param tasks   The current task list.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage handler for saving tasks.
     * @throws IOException If an error occurs during execution.
     */
    public abstract void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException;

    /**
     * Indicates whether this command should terminate the application.
     *
     * @return true if this command exits the application, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
