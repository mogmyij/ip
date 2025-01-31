package mab.task;

/**
 * Abstract base class representing a task with common attributes.
 * Provides foundation for task management and persistence.
 */
public abstract class Task {
    String text;
    boolean done;

    /**
     * Creates a new generic task.
     * 
     * @param t Text description of task
     * @param d Initial completion status
     */
    public Task(String t, boolean d) {
        text = t; done = d;
    }

    /**
     * Updates task completion status.
     * 
     * @param d New completion status
     */
    public void setDone(boolean d) {
        done = d;
    }
    /**
     * Updates task description.
     * 
     * @param t New task description
     */
    public void setText(String t) {
        text = t;
    }
    /**
     * @return Text description of task
     */
    public String getText() {
        return text;
    }
    /**
     * @return Task completion status
     */
    public boolean getDone() {
        return done;
    }

    /**
     * Generates storage-formatted string representation.
     * 
     * @return String suitable for persistent storage
     */
    public abstract String getSaveString();

    /**
     * @return Display format: {@code [status] [description]}
     * where status is "X" if done, " " if not done
     */
    @Override
    public String toString() { return String.format("[%s] %s", done ? "X": " ", text); }
}
