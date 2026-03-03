package Duke.command;

import Duke.storage.Storage;
import Duke.task.Task;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

/**
 * Represents a command that lists all tasks.
 */
public class ListCommand extends Command {
    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) {
        if (tasks.size() == 0) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t);
        }
    }
}