import java.util.ArrayList;

// Delete command
public class DeleteCommand extends Command {
    public DeleteCommand(String args) {
        super(args);
    }

    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        if (args.isBlank()) throw new MabException("argument cannot be empty");
        int pos;
        try {
            pos = Integer.parseInt(args);
        } catch(NumberFormatException e) {
            throw new MabException(String.format("%s is not a valid number", args));
        }
        if (pos < 1 || pos > list.size()) {
            throw new MabException(String.format("argument cannot be beyond range 1 - %d", list.size()));
        }

        Task t = list.remove(pos - 1);
        System.out.println("\n============================================================================");
        System.out.printf("deleted task %s: %s\n", args, t.toString());
        System.out.println("============================================================================\n");
    }
}
