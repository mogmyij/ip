package mab.task;

import java.time.LocalDateTime;
import mab.util.DateTimeUtil;

public class Events extends Task {
    LocalDateTime from;
    LocalDateTime to;

    public Events(String t, boolean d, String fr, String to) {
        super(t,d); 
        this.from = DateTimeUtil.parseDateTime(fr);
        this.to = DateTimeUtil.parseDateTime(to);
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] %s (from: %s to: %s)", "E", 
                super.toString(), DateTimeUtil.localDateTimeToString(from), 
                DateTimeUtil.localDateTimeToString(to)
                );
    }

    public String getSaveString() {
        return String.format(
                "E | %s | %s | %s | %s", 
                Boolean.toString(super.getDone()), super.getText(), 
                DateTimeUtil.localDateTimeToString(from), 
                DateTimeUtil.localDateTimeToString(to)
                );
    }
}
