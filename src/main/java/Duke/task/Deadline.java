package Duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDate byDate;   // null if invalid
    private final String rawBy;
    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String by) {
        super(description);

        this.rawBy = by;

        LocalDate parsedDate = null;
        try {
            parsedDate = LocalDate.parse(by);
        } catch (Exception e) {
            // ignore, keep parsedDate = null
        }

        this.byDate = parsedDate;
    }

    @Override
    public String toString() {

        if (byDate != null) {
            DateTimeFormatter output =
                    DateTimeFormatter.ofPattern("MMM dd yyyy");

            return "[D]" + super.toString()
                    + " (by: " + byDate.format(output) + ")";
        } else {
            // fallback
            return "[D]" + super.toString()
                    + " (by: " + rawBy + ")";
        }
    }

    @Override
    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "D | " + status + " | " + description + " | " + rawBy;
    }
}
