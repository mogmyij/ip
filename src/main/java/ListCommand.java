import java.util.ArrayList;

// List command
public class ListCommand extends Command {
    public ListCommand(String args) {
        super(args);
    }

    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        System.out.println("\n============================================================================");
        for (int i = 1; i <= list.size(); i++) {
            System.out.printf("%d. %s\n", i, list.get(i - 1));
        }
        System.out.println("============================================================================\n");
    }
}
