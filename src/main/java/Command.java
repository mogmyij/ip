import java.util.ArrayList;

public abstract class Command {
    protected String args;

    public Command(String args) {
        this.args = args;
    }

    public abstract void execute(ArrayList<Task> list) throws MabException;
}
