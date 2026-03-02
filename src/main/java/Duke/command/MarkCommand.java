package Duke.command;


import Duke.storage.Storage;
import Duke.task.Task;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class MarkCommand extends Command {
    private final int index; // 0-based

    public MarkCommand(String args) throws IOException {
        try {
            this.index = Integer.parseInt(args.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new IOException("mark requires a task number. Example: mark 2");
        }
    }

    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException {
        tasks.get(index).mark();
        Storage.save((ArrayList<Task>) tasks.getTasks());
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + tasks.get(index));
    }
}