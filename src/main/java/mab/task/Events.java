package mab.task;

import java.time.LocalDateTime;

import mab.util.DateTimeUtil;

/**
 * Represents an event with start/end times.
 * Contains date time  boundaries for event duration.
 */
public class Events extends Task {
    LocalDateTime from;
    LocalDateTime to;

    /**
     * Creates time-bounded event task.
     * 
     * @param t Description text
     * @param d Completion status
     * @param fr Start time string
     * @param to End time string
     */
    public Events(String t, boolean d, String fr, String to) {
        super(t,d); 
        this.from = DateTimeUtil.parseDateTime(fr);
        this.to = DateTimeUtil.parseDateTime(to);
    }

    /**
     * @return Display format: {@code [E][status] [description] (from: [start] to: [end])}
     */
    @Override
    public String toString() {
        return String.format(
                "[%s] %s (from: %s to: %s)", "E", 
                super.toString(), DateTimeUtil.localDateTimeToString(from), 
                DateTimeUtil.localDateTimeToString(to)
                );
    }

    /**
     * @return Storage format: {@code E | [status] | [description] | [start] | [end]}
     * @implSpec Uses {@link DateTimeUtil#localDateTimeToString} for time formatting
     */
    public String getSaveString() {
        return String.format(
                "E | %s | %s | %s | %s", 
                Boolean.toString(super.getDone()), super.getText(), 
                DateTimeUtil.localDateTimeToString(from), 
                DateTimeUtil.localDateTimeToString(to)
                );
    }
}
