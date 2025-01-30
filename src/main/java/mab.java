import java.io.IOException;

public class Mab {
    MabStorage ms;
    TaskList list;
    Ui ui;

    public Mab() {
        ms = new MabStorage();
        list = new TaskList(ms.read());
        ui = new Ui();
    }

    private void run() {
        ui.showGreeting();
        String text = "";
        while (true) {
            text = ui.readCommand();
            if (text.equals("bye")) break;
            try{
                Parser.parse(text).execute(list.getTasks());
            } catch (MabException e) {
                System.out.println(e.getMessage());
            }
        }
        ui.showGoodbye();
    }

    public static void main(String[] args) throws IOException{
        Mab mab = new Mab();
        mab.run();
    }
}
