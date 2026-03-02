package Duke.parser;

import Duke.command.*;
import Duke.storage.Storage;
import Duke.task.*;
import java.io.IOException;

public class Parser {

    public static Command parse(String fullCommand) throws IOException {
        String input = fullCommand.trim();
        if (input.isEmpty()) throw new IOException("Please type a command.");

        String[] split = input.split("\\s+", 2);
        String commandWord = split[0];
        String args = split.length > 1 ? split[1].trim() : "";

        switch (commandWord) {
        case "bye":
            return new ExitCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(args);
        case "unmark":
            return new UnmarkCommand(args);
        case "delete":
            return new DeleteCommand(args);
        case "todo":
            return new TodoCommand(args);
        case "deadline":
            return new DeadlineCommand(args);
        case "event":
            return new EventCommand(args);
        case "find":
            return new FindCommand(args);
        default:
            throw new IOException("I don't know what that means.");
        }
    }
}
