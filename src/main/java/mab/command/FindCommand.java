package mab.command;

import mab.MabException;
import java.util.ArrayList;
import mab.task.Task;
import mab.util.Ui;

/**
 * Handles searching for tasks containing specified keywords.
 */
public class FindCommand extends Command{

    /**
     * Creates a new search command processor.
     * 
     * @param args Search keyword(s) string
     */
    public FindCommand(String args) {
        super(args);
    }

    /**
     * Displays tasks containing search keyword in their description.
     * 
     * @param list Task list to search through
     * @throws MabException If search keyword is empty
     * 
     * @implSpec Search is case-insensitive and matches partial words
     * @implNote Output format matches ListCommand but only shows matches
     */
    @Override
    public void execute(ArrayList<Task> tasks) throws MabException {
        Ui out = new Ui();
        if (args.isEmpty()) {
            throw new MabException("Please provide a keyword to search for.");
        }
        String keyword = args.toLowerCase();
        out.divider();
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getText().toLowerCase().contains(keyword)) {
                System.out.printf("%d. %s\n", i + 1, task.toString());
            }
        }
        out.divider();
    }
}
