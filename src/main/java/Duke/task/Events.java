package Duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * represents a Event task which has a description, a from date and a to date
 *
 * @return String formatted as "[T][status] description".
 */
public class Events extends Task {
    private final LocalDate toDate;   // null if invalid
    private final String rawto;

    private final LocalDate fromDate;   // null if invalid
    private final String rawfrom;

    /**
     * Creates an Events task with a start and end date string.
     * Attempts to parse both into {@link LocalDate}. If parsing fails,
     * the corresponding parsed date will remain null.
     *
     * @param description Description of the event.
     * @param from Start date string (expected yyyy-MM-dd).
     * @param to End date string (expected yyyy-MM-dd).
     */
    public Events(String description, String from, String to) {
        super(description);
        this.rawfrom = from;
        this.rawto = to;

        LocalDate toparsedDate = null;
        LocalDate fromparsedDate = null;
        try {
            toparsedDate = LocalDate.parse(from);
        } catch (Exception e) {
            // ignore, keep parsedDate = null
        }
        try {
            fromparsedDate = LocalDate.parse(to);
        } catch (Exception e) {
            // ignore, keep parsedDate = null
        }
        this.toDate = toparsedDate;
        this.fromDate = fromparsedDate;
    }

    /**
     * Returns a user-friendly string representation of this event.
     * If both dates are valid, they will be displayed in "MMM dd yyyy" format;
     * otherwise, the raw inputs are shown.
     *
     * @return String representation of this event.
     */
    public String toString() {

        if (toDate != null && fromDate != null) {
            DateTimeFormatter output =
                    DateTimeFormatter.ofPattern("MMM dd yyyy");

            return "[D]" + super.toString()
                    + " (from: " + fromDate.format(output) + " to: " + toDate.format(output) +")";
        } else {
            // fallback
            return "[D]" + super.toString()
                    + " (from: " + rawfrom + " to: " + rawto + ")";
        }
    }

    @Override
    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "E | " + status + " | " + description + " | " + rawfrom + " | " + rawto;
    }
}
