
public class Deadlines extends Task {
    String deadline;

    public Deadlines(String t, boolean d, String dl) {super(t,d); deadline = dl;}

    @Override
    public String toString() {
        return String.format("[%s] %s (by: %s)", "D", super.toString(), deadline);
    }
    public String getDeadline() {
        return deadline;
    }

    public String getSaveString(){
        return String.format("D | %s | %s | %s", Boolean.toString(super.getDone()), super.getDone(), deadline);
    }
}
