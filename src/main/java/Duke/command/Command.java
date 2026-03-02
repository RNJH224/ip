package Duke.command;

import Duke.storage.Storage;
import Duke.tasklist.Tasklist;
import Duke.ui.Ui;

import java.io.IOException;

public abstract class Command {
    public abstract void execute(Tasklist tasks, Ui ui, Storage storage) throws IOException;
    public boolean isExit() { return false; }
}
