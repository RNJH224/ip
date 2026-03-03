package Duke.command;

import Duke.storage.Storage;
import Duke.task.Task;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String args) throws IOException {
        if (args.trim().isEmpty()) {
            throw new IOException("Find command requires a keyword.");
        }
        this.keyword = args.trim();
    }
    @Override
    public void execute(Tasklist tasks, Ui ui, Storage storage) {

        System.out.println("Here are the matching tasks in your list:");

        int count = 1;

        for (Task t : tasks.getTasks()) {
            if (t.toString().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(count + ". " + t);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("No matching tasks found.");
        }
    }
}
