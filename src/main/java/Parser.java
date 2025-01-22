
public class Parser {

    public static Command parse(String c){
        String[] tokens = c.trim().split("\\s+", 2);
        String comm = tokens[0].toLowerCase(), args = tokens.length > 1 ? tokens[1] : "";
        return new Command(comm,args);
    }
}
