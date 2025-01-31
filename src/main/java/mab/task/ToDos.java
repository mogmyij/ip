package mab.task;

/**
 * Represents a basic todo item without temporal constraints.
 * Marked with [T] in displayed lists.
 */
public class ToDos extends Task{

    /**
     * Creates a new todo item.
     * 
     * @param t Text description
     * @param d Initial completion status
     */
    public ToDos(String t, boolean d){
        super(t,d);
    }

    /**
     * @return Display format: {@code [T][status] [description]}
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", "T", super.toString());
    }

    /**
     * @return Storage format: {@code T | [status] | [description]}
     */
    public String getSaveString() { 
        return String.format(
                "T | %s | %s", 
                Boolean.toString(super.getDone()), this.getText()
                ); 
    }
}
