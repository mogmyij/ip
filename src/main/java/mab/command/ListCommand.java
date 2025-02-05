package mab.command;

import java.util.ArrayList;

import mab.task.Task;
import mab.MabException;

/**
 * Displays all tasks in the list with their current status.
 */
public class ListCommand extends Command {
     /**
     * Creates a new list command processor.
     * 
     * @param args Unused parameter for command consistency
     */
    public ListCommand(String args) {
        super(args);
    }

    /**
     * Prints all tasks in numbered format with status indicators.
     * 
     * @param list The task list to display
     * @throws MabException Never thrown under normal operation
     */
    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        System.out.println("\n============================================================================");
        for (int i = 1; i <= list.size(); i++) {
            System.out.printf("%d. %s\n", i, list.get(i - 1));
        }
        System.out.println("============================================================================\n");
    }
}
