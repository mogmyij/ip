import java.util.ArrayList;

// Todo command
public class ToDosCommand extends Command {
    public ToDosCommand(String args) {
        super(args);
    }

    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        if (args.isBlank()) throw new MabException("argument cannot be empty");
        
        ToDos newTask = new ToDos(args, false);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new todo: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
        new MabStorage().update(list);
    }
}
