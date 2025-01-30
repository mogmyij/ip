package mab.task;

import java.time.LocalDateTime;
import mab.util.DateTimeUtil;

public class Deadlines extends Task {
    LocalDateTime deadline;

    public Deadlines(String t, boolean d, String dl) {
        super(t,d); 
        deadline = DateTimeUtil.parseDateTime(dl);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (by: %s)", "D", super.toString(), 
                DateTimeUtil.localDateTimeToString(deadline)
                );
    }
    public String getDeadline() {
        return deadline.toString();
    }

    public String getSaveString(){
        return String.format("D | %s | %s | %s", Boolean.toString(super.getDone()), super.getText(), 
                DateTimeUtil.localDateTimeToString(deadline)
                );
    }
}
