package Duke.command;


import Duke.storage.Storage;
import Duke.task.Task;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a command that deletes a task from the task list.
 * Expected input format:
 * delete <task_number>
 */
public class DeleteCommand extends Command {
    private final int index; // 0-based

    public DeleteCommand(String args) throws IOException {
        try {
            this.index = Integer.parseInt(args.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new IOException("Delete requires a task number. Example: delete 2");
        }
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException {

        if (index < 0 || index >= tasks.size()) {
            throw new IOException("Invalid task number.");
        }

        Task removed = tasks.delete(index);
        storage.save((ArrayList<Task>) tasks.getTasks());


        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + removed);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}