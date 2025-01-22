import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        while (!ended) {
            text = reader.readLine();
            if (text.equals("bye")) break;

            System.out.println("\n============================================================================");
            System.out.println(text);
            System.out.println("============================================================================");
        }
        System.out.println(goodbye);
    }
}
