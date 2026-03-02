package Duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    private final LocalDate toDate;   // null if invalid
    private final String rawto;

    private final LocalDate fromDate;   // null if invalid
    private final String rawfrom;

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

    public String toString() {

        if (toDate != null && fromDate != null) {
            DateTimeFormatter output =
                    DateTimeFormatter.ofPattern("MMM dd yyyy");

            return "[D]" + super.toString()
                    + " (from: " + fromDate.format(output) + " to: " + toDate.format(output) +")";
        } else {
            // fallback
            return "[D]" + super.toString()
                    + " (from: " + rawfrom + "to:" + rawto + ")";
        }
    }

    @Override
    public String toFileFormat() {
        String status = isDone ? "1" : "0";
        return "E | " + status + " | " + description + " | " + rawfrom + " | " + rawto;
    }
}
