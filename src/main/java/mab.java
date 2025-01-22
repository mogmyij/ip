import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class mab {

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
        ArrayList<String> list = new ArrayList<>();

        while (!ended) {
            text = reader.readLine();

            switch (text) {
                case "bye" -> ended = true;
                case "list" -> {
                    System.out.println("\n============================================================================");
                    for (int i = 1; i <= list.size() ; i++ ) System.out.printf("%d. %s\n", i, list.get(i - 1));   
                    System.out.println("============================================================================");
                    continue;
                }
            }
            list.add(text);

            System.out.println("\n============================================================================");
            System.out.printf("added: %s\n", text);
            System.out.println("============================================================================");
        }
        System.out.println(goodbye);
    }
}
