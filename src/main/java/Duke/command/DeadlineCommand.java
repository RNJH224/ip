package Duke.command;

import Duke.storage.Storage;
import Duke.task.Deadline;
import Duke.task.Task;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.io.IOException;
import java.util.ArrayList;

public class DeadlineCommand extends Command {
    private final String description;
    private final String by;



    public DeadlineCommand(String args) throws IOException {
        if (args.isEmpty()) {
            throw new IOException("The description of a deadline cannot be empty.");
        }

        String[] parts = args.split("/by", 2);
        if (parts.length < 2) {
            throw new IOException("Deadline must have a by time.");
        }

        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    /**
     *
     * @param tasks
     * @param ui
     * @param storage
     * @throws IOException
     */

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException {
        Task t = new Deadline(description, by);
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