package Duke.task;

/**
 * represents a generic task with a desription and completion status of any task
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task with the given description.
     * @param description Description of the Task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done
     */
    public void mark() {
        isDone = true;
    }

    /**
     * Unmark the task as not done
     */
    public void unmark() {
        isDone = false;
    }

    /**
     * Returns the status icon for this task.
     * @return "X" if done and blank if not
     */
    public String Status() {
        return isDone ? "X" : " ";
    }

    /**
     * Converts this task in to a format suitable for saving into a txt file
     * @return A string containing the task type, completion status, and description.
     */
    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "T | " + status + " | " + description;
    }

    /**
     * Returns a user-friendly string representation of this task.
     *
     * @return String formatted as "[status] description".
     */
    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + description;
    }
}
