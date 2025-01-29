
public class Events extends Task {
    String from;
    String to;

    public Events(String t, boolean d, String fr, String to) {super(t,d); from = fr; this.to = to;}

    @Override
    public String toString() {
        return String.format("[%s] %s (from: %s to: %s)", "E", super.toString(), from, to);
    }

    public String getSaveString() {
        return String.format("E | %s | %s | %s | %s", Boolean.toString(super.getDone()), super.getText(), from, to);
    }
}
