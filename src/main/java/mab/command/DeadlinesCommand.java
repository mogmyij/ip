package mab.command;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import mab.task.Task;
import mab.task.Deadlines;
import mab.util.MabStorage;
import mab.MabException;

/**
 * Represents a command to add a new deadline task to the task list.
 */
public class DeadlinesCommand extends Command {

    /**
     * constructor for DeadlinesCommand. 
     *
     * @param args description and date and time of the deadline task.
     */
    public DeadlinesCommand(String args) {
        super(args);
    }

    /**
     * Adds a new deadline task to the task list.
     *
     * @param list list that the deadline will be added to.
     * @throws MabException when description or date and time is empty or invalid.
     */
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

        try{
            Deadlines newTask = new Deadlines(temp[0], false, temp[1]);
            list.add(newTask);
            System.out.println("\n============================================================================");
            System.out.printf("Added new deadline: %s\n", newTask.toString());
            System.out.println("============================================================================\n");
            new MabStorage().update(list);
        } catch (DateTimeParseException e) {
            throw new MabException("Invalid date & time format, try using: YYYY-MM-DD HH:MM");
        }
    }
}
