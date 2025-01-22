
public class Task {
    String text;
    boolean done;

    public Task(String t, boolean d) {
        text = t; done = d;
    }

    public void setDone(boolean d) {done = d;}
    public void setText(String t) {text = t;}

    @Override
    public String toString() { return String.format("[%s] %s", done ? "X": " ", text); }
}
