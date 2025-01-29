import java.util.ArrayList;

public class MarkingCommand extends Command {
    private final boolean markAsDone;

    public MarkingCommand(String args, boolean markAsDone) {
        super(args);
        this.markAsDone = markAsDone;
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

        list.get(pos - 1).setDone(markAsDone);
        System.out.println("\n============================================================================");
        System.out.printf("marked task %s: %s as %s\n", 
                args, 
                list.get(pos - 1).toString(),
                markAsDone ? "done" : "not done");
        System.out.println("============================================================================\n");
        new MabStorage().update(list);
    }
}
