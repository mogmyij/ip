import java.util.ArrayList;

// Deadline command
public class DeadlinesCommand extends Command {
    public DeadlinesCommand(String args) {
        super(args);
    }

    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        if (args.isBlank()) {
            throw new MabException("description cannot be empty, try using: \"deadline [description] /by [date & time]\"");
        }
        String[] temp = args.split("/by", 2);
        if (temp.length < 2) {
            throw new MabException("date & time cannot be empty, try using \"deadline [description] /by [date & time]\"");
        }
        if(temp[0].isBlank() || temp[1].isBlank()) {
            throw new MabException("fields cannot be empty, try using: \"deadline [description] /by [date & time]\"");
        }

        Deadlines newTask = new Deadlines(temp[0], false, temp[1]);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new deadline: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
        new MabStorage().update(list);
    }
}
