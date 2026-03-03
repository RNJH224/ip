package Duke.task;

/**
 * Represents a todo task which only has a description
 */
public class ToDo extends Task {

    /**
     * Creates a ToDo task with the given description.
     *
     * @param description Description of the task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a user-friendly string representation of this ToDo task.
     *
     * @return String formatted as "[T][status] description".
     */
    @Override
    public String toString() {
        return "[T][" + Status() + "] " + description;
    }
}