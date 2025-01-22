import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Mab {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String greet = 
            """
            ██╗  ██╗███████╗██╗     ██╗      ██████╗  ██╗        ██╗███╗   ███╗    ███╗   ███╗ █████╗ ██████╗ 
            ██║  ██║██╔════╝██║     ██║     ██╔═══██╗ ██║        ██║████╗ ████║    ████╗ ████║██╔══██╗██╔══██╗
            ███████║█████╗  ██║     ██║     ██║   ██║ ██║        ██║██╔████╔██║    ██╔████╔██║███████║██████╔╝
            ██╔══██║██╔══╝  ██║     ██║     ██║   ██║ ╚═╝        ██║██║╚██╔╝██║    ██║╚██╔╝██║██╔══██║██╔══██╗
            ██║  ██║███████╗███████╗███████╗╚██████╔╝ ██╗        ██║██║ ╚═╝ ██║    ██║ ╚═╝ ██║██║  ██║██████╔╝
            ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝  ╚═╝        ╚═╝╚═╝     ╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═════╝ 


            how can i help you?
            """;

        String goodbye = """
            ╭───────────────────╮
            │     Goodbye!      │
            │  See you later!   │
            ╰───────────────────╯
            """;

        System.out.println(greet);
        boolean ended = false;
        String text = "";
        ArrayList<Task> list = new ArrayList<>();

        //chatbot loop
        while (!ended) {
            text = reader.readLine();

            //detects the users intention
            switch (text) {
                case "bye" -> ended = true;
                case "list" -> {
                    System.out.println("\n============================================================================");
                    for (int i = 1; i <= list.size() ; i++ ) System.out.printf("%d. %s\n", i, list.get(i - 1));   
                    System.out.println("============================================================================\n");
                    continue;
                }
            }

            if(text.startsWith("mark") || text.startsWith("unmark")){
                String[] temp = text.split(" ");
                if (temp.length != 2) {
                    System.out.println("please follow the corrent formmat \"mark [task number]\" or \"unmark [task number]\"");
                    continue;
                }
                list.get(Integer.parseInt(temp[1]) - 1).setDone(temp[0].equals("mark"));

                System.out.println("\n============================================================================");
                System.out.printf("marked task %s: %s as %s\n", 
                        temp[1], 
                        list.get(Integer.parseInt(temp[1]) - 1).toString(),
                        temp[0].equals("mark") ? "done" : "not done");
                System.out.println("============================================================================\n");
                continue;
            }
            

            //if no specified intention then simply add the text to the list as a task
            list.add(new Task(text, false));
            System.out.println("\n============================================================================");
            System.out.printf("added task: %s\n", text);
            System.out.println("============================================================================\n");
        }
        System.out.println(goodbye);
    }
}
