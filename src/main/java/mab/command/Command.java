package mab.command;

import java.util.ArrayList;
import mab.task.Task;
import mab.MabException;

public abstract class Command {
    protected String args;

    public Command(String args) {
        this.args = args;
    }

    public abstract void execute(ArrayList<Task> list) throws MabException;
}
