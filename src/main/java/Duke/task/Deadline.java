package Duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task that must be done by a specific date.
 * The deadline is stored as a parsed {@link LocalDate} when possible,
 * otherwise the original input is kept for display and saving.
 */
public class Deadline extends Task {
    private final LocalDate byDate;   // null if invalid
    private final String rawBy;
    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("MMM dd yyyy");

    /**
     * Creates a Deadline task with the given description and due date string.
     * Attempts to parse the due date into a {@link LocalDate}. If parsing fails,
     * the raw input is kept and the parsed date remains null.
     *
     * @param description Description of the task.
     * @param by Due date string (expected in ISO-8601 format yyyy-MM-dd).
     */
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

    /**
     * Returns a user-friendly string representation of this deadline.
     * If the date is valid, it will be displayed in "MMM dd yyyy" format;
     * otherwise, the raw input is shown.
     *
     * @return String representation of this deadline.
     */
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

    /**
     * Converts this deadline into a format suitable for saving into a text file.
     *
     * @return A string containing the task type, completion status, description, and raw deadline input.
     */
    @Override
    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "D | " + status + " | " + description + " | " + rawBy;
    }
}
