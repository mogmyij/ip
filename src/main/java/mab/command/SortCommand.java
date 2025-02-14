package mab.command;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Collections;

import mab.task.Task;
import mab.MabException;

/**
 * Represents a command that the user can input.
 *
 * @field args The arguments of the command.
 *
 */
public class SortCommand extends Command {

    public SortCommand(String args) {
        super(args);
    }

    /**
     * Executes the command.
     *
     * @param list The list of tasks to perform the command on.
     * @throws MabException If the command fails to execute due to missing or invalid arguments.
    */
    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        Collections.sort(list, (t1, t2) -> {
            LocalDateTime time1 = t1.getStartDateTime();
            LocalDateTime time2 = t2.getStartDateTime();

            if (time1 == null && time2 == null) return 0;
            if (time1 == null) return 1;
            if (time2 == null) return -1;

            return time1.compareTo(time2);
        });
    }
}
