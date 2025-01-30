package mab.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
    BufferedReader reader;

    private static final String GREETING_STRING = 
        """
        ██╗  ██╗███████╗██╗     ██╗      ██████╗  ██╗        ██╗███╗   ███╗    ███╗   ███╗ █████╗ ██████╗ 
        ██║  ██║██╔════╝██║     ██║     ██╔═══██╗ ██║        ██║████╗ ████║    ████╗ ████║██╔══██╗██╔══██╗
        ███████║█████╗  ██║     ██║     ██║   ██║ ██║        ██║██╔████╔██║    ██╔████╔██║███████║██████╔╝
        ██╔══██║██╔══╝  ██║     ██║     ██║   ██║ ╚═╝        ██║██║╚██╔╝██║    ██║╚██╔╝██║██╔══██║██╔══██╗
        ██║  ██║███████╗███████╗███████╗╚██████╔╝ ██╗        ██║██║ ╚═╝ ██║    ██║ ╚═╝ ██║██║  ██║██████╔╝
        ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝  ╚═╝        ╚═╝╚═╝     ╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═════╝ 


        how can i help you?
        """;


    private static final String GOODBYE_STRING = 
        """
        ╭───────────────────╮
        │     Goodbye!      │
        │  See you later!   │
        ╰───────────────────╯
        """;

    private static final String DIVIDER = "\n============================================================================\n";


    public Ui() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void divider() {
        System.out.println(DIVIDER);
    }

    public void showGreeting() {
        System.out.println(GREETING_STRING);
    }

    public void showGoodbye() {
        System.out.println(GOODBYE_STRING);
    }

    public String readCommand() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the command");
            return "";
        }
    }

}
