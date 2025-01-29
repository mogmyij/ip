import java.util.ArrayList;

// Event command
public class EventsCommand extends Command {
    public EventsCommand(String args) {
        super(args);
    }

    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        if (args.isBlank()) {
            throw new MabException("description cannot be empty, try using: \"event [description] /from [time] /to [time]\"");
        }
        String[] description = args.split("/from", 2);
        if (description.length < 2) {
            throw new MabException("time cannot be empty, try using: \"event [description] /from [time] /to [time]\"");
        }
        String[] fromTo = description[1].split("/to", 2);
        if (description.length < 2) {
            throw new MabException("time cannot be empty, try using: \"event [description] /from [time] /to [time]\"");
        }
        if(description[0].isBlank() || fromTo[0].isBlank() || fromTo[1].isBlank()) {
            throw new MabException("fields cannot be blank, try using: \"event [description] /from [time] /to [time]\"");
        }

        Events newTask = new Events(description[0], false, fromTo[0], fromTo[1]);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new Event: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
        new MabStorage().update(list);
    }
}
