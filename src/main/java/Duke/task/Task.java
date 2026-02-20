package Duke.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void mark() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

    public String Status() {
        return isDone ? "X" : " ";
    }

    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "T | " + status + " | " + description;
    }

}
