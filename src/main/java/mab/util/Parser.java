package mab.util;

import mab.command.*;
import mab.MabException;

public class Parser {

    public static Command parse(String c) throws MabException {
        String[] tokens = c.trim().split("\\s+", 2);//split the command using spaces into 2 parts 
        String comm = tokens[0].toLowerCase(), args = tokens.length > 1 ? tokens[1] : "";

        return switch (comm) {
            case "list" -> new ListCommand(args);
            case "todo" -> new ToDosCommand(args);
            case "deadline" -> new DeadlinesCommand(args);
            case "event" -> new EventsCommand(args);
            case "mark" -> new MarkingCommand(args, true);
            case "unmark" -> new MarkingCommand(args, false);
            case "delete" -> new DeleteCommand(args);
            default -> throw new MabException("Hmmmmmm i didn't get that please try again :)");
        };
    }
}
