package Duke.task;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D][" + Status() + "] "
                + description + " (by: " + by + ")";
    }

    @Override
    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "D | " + status + " | " + description + " | " + by;
    }
}
