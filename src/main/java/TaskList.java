import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> t){
        tasks = t; 
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }
}
