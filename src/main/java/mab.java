import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Mab {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MabStorage ms = new MabStorage();

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
        String text = "";
        ArrayList<Task> list = new ArrayList<>();

        try{
            new LoadCommand().execute(list);
            //chatbot loop
        } catch (MabException e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            text = reader.readLine();
            if (text.equals("bye")) break;
            try{
                Parser.parse(text).execute(list);
            } catch (MabException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(goodbye);

    }
}
