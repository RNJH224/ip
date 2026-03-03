package Duke.command;

import Duke.storage.Storage;
import Duke.task.Events;
import Duke.task.Task;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a command that creates a new Event task.
 * Expected input format:
 * event <description> from <date> to <date>
 */
public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String args) throws IOException {
        if (args.isEmpty()) {
            throw new IOException("The description of a Event cannot be empty.");
        }

        String[] parts = args.split("from|to");
        if (parts.length < 3) {
            throw new IOException("Event must have to and/or from time.");
        }

        this.description = parts[0].trim();
        this.from = parts[1].trim();
        this.to = parts[2].trim();
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException {
        Task t = new Events(description, from, to);
        tasks.add(t);

        try {
            storage.save((ArrayList<Task>) tasks.getTasks());
        } catch (IOException e) {
            throw new IOException("Could not save tasks to file.");
        }

        // If you don't have Ui methods yet, you can temporarily print directly:
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}