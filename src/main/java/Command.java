import java.util.ArrayList;

public class Command {

    String type;
    String args;

    public Command(String t, String a) {type = t; args = a;}

    public void run(ArrayList<Task> list){
        switch (type) {
            case "list" -> listCommand(list);
            case "todo" -> todoCommand(list);
            case "deadline" -> deadlineCommand(list); 
            case "event" -> eventCommand(list); 
            case "mark" -> markingCommand(list);
            case "unmark" -> markingCommand(list); 
            default -> System.out.println("hmmmmmmm i didnt understand that try again");
        }
    }

    private void listCommand(ArrayList<Task> list) {
        System.out.println("\n============================================================================");
        for (int i = 1; i <= list.size() ; i++ ) System.out.printf("%d. %s\n", i, list.get(i - 1));   
        System.out.println("============================================================================\n");
    }

    private void markingCommand(ArrayList<Task> list) {
        list.get(Integer.parseInt(args) - 1).setDone(type.equals("mark"));
        System.out.println("\n============================================================================");
        System.out.printf("marked task %s: %s as %s\n", 
                args, 
                list.get(Integer.parseInt(args) - 1).toString(),
                type.equals("mark") ? "done" : "not done");
        System.out.println("============================================================================\n");
    }

    private void todoCommand(ArrayList<Task> list){
        ToDos newTask = new ToDos(args, false);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new todo: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
    }

    private void deadlineCommand(ArrayList<Task> list){
        String[] temp = args.split("/by", 2);
        Deadlines newTask = new Deadlines(temp[0],false,temp[1]);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new deadline: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
    }

    private void eventCommand(ArrayList<Task> list){
        String[] description = args.split("/from", 2);
        String[] fromTo = description[1].split("/to", 2);
        Events newTask = new Events(description[0], false, fromTo[0], fromTo[1]);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new Event: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
    }
}
