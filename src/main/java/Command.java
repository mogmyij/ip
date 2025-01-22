import java.util.ArrayList;

public class Command {

    String type;
    String args;

    public Command(String t, String a) {type = t; args = a;}

    public void run(ArrayList<Task> list){
        try{
            switch (type) {
                case "list" -> listCommand(list);
                case "todo" -> todoCommand(list);
                case "deadline" -> deadlineCommand(list); 
                case "event" -> eventCommand(list); 
                case "mark" -> markingCommand(list);
                case "unmark" -> markingCommand(list); 
                case "delete" -> deleteCommand(list);
                default -> throw new MabException("Hmmmmmm i didn't get that please try again :)''");
            }
        } catch (MabException e) {
            System.out.println(e.toString());
        }
    }

    private void listCommand(ArrayList<Task> list) throws MabException{
        System.out.println("\n============================================================================");
        for (int i = 1; i <= list.size() ; i++ ) System.out.printf("%d. %s\n", i, list.get(i - 1));   
        System.out.println("============================================================================\n");
    }

    private void markingCommand(ArrayList<Task> list) throws MabException{
        int pos;

        if (args.isBlank()) throw new MabException("argument cannot be empty");
        try {pos = Integer.parseInt(args);} 
        catch(NumberFormatException e){throw new MabException(String.format("%s is not a valid number", args));}
        if (pos < 1 || pos > list.size()) throw new MabException(String.format("argument cannot be beyond range 1 - %d", list.size()));

        list.get(pos - 1).setDone(type.equals("mark"));
        System.out.println("\n============================================================================");
        System.out.printf("marked task %s: %s as %s\n", 
                args, 
                list.get(Integer.parseInt(args) - 1).toString(),
                type.equals("mark") ? "done" : "not done");
        System.out.println("============================================================================\n");
    }

    private void todoCommand(ArrayList<Task> list) throws MabException{
        if (args.isBlank()) throw new MabException("argument cannot be empty");

        ToDos newTask = new ToDos(args, false);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new todo: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
    }

    private void deadlineCommand(ArrayList<Task> list) throws MabException {
        if (args.isBlank()) throw new MabException("description cannot be empty, try using: \"deadline [description] /by [date & time]\"");
        String[] temp = args.split("/by", 2);
        if (temp.length < 2) throw new MabException("date & time cannot be empty, try using \"deadline [description] /by [date & time]\"");
        if(temp[0].isBlank() || temp[1].isBlank()) throw new MabException("fields cannot be empty, try using: \"deadline [description] /by [date & time]\"");

        Deadlines newTask = new Deadlines(temp[0],false,temp[1]);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new deadline: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
    }

    private void eventCommand(ArrayList<Task> list) throws MabException {
        if (args.isBlank()) throw new MabException("description cannot be empty, try using: \"event [description] /from [time] /to [time]\"");
        String[] description = args.split("/from", 2);
        if (description.length < 2) throw new MabException("time cannot be empty, try using: \"event [description] /from [time] /to [time]\"");
        String[] fromTo = description[1].split("/to", 2);
        if (description.length < 2) throw new MabException("time cannot be empty, try using: \"event [description] /from [time] /to [time]\"");
        if(description[0].isBlank() || fromTo[0].isBlank() || fromTo[1].isBlank()) throw new MabException("fields cannot be blank, try using: \"event [description] /from [time] /to [time]\"");

        Events newTask = new Events(description[0], false, fromTo[0], fromTo[1]);
        list.add(newTask);
        System.out.println("\n============================================================================");
        System.out.printf("Added new Event: %s\n", newTask.toString());
        System.out.println("============================================================================\n");
    }
    
    private void deleteCommand(ArrayList<Task> list) throws MabException{
        int pos;
        if (args.isBlank()) throw new MabException("argument cannot be empty");
        try {pos = Integer.parseInt(args);} 
        catch(NumberFormatException e){throw new MabException(String.format("%s is not a valid number", args));}
        if (pos < 1 || pos > list.size()) throw new MabException(String.format("argument cannot be beyond range 1 - %d", list.size()));

        Task t = list.remove(pos - 1);
        System.out.println("\n============================================================================");
        System.out.printf("deleted task %s: %s\n", 
                args, 
                t.toString()
                );
        System.out.println("============================================================================\n");
    }
}
