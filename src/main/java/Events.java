public class Events extends Task {
    protected String from;
    protected String to;

    public Events(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "[E][" + Status() + "] "
                + description + " (from: " + from + " to: " + to + ")";
    }
}
