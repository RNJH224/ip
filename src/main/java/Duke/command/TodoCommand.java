package Duke.command;

import Duke.storage.Storage;
import Duke.task.Task;
import Duke.task.ToDo;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a command that creates a new ToDo task.
 * Expected input format:
 * todo <description>
 */
public class TodoCommand extends Command {
    private final String description;

    public TodoCommand(String args) throws IOException {
        if (args.isEmpty()) {
            throw new IOException("Todo needs a description. Example: todo read book");
        }
        this.description = args.trim();
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException {
        Task t = new ToDo(description);
        tasks.add(t);

        try {
            storage.save((ArrayList<Task>) tasks.getTasks());
        } catch (IOException e) {
            throw new IOException("Could not save tasks to file.");
        }

        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}