
public class Deadlines extends Task {
    String deadline;

    public Deadlines(String t, boolean d, String dl) {super(t,d); deadline = dl;}

    @Override
    public String toString() {
        return String.format("[%s] %s (by: %s)", "D", super.toString(), deadline);
    }
}
