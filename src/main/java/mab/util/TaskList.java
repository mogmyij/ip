package mab.util;

import java.util.ArrayList;
import mab.task.Task;

public class TaskList {
    ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> t){
        tasks = t; 
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }
}
