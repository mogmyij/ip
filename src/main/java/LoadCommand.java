import java.util.ArrayList;

public class LoadCommand extends Command {
    private MabStorage ms;

    public LoadCommand() {
        super("");
        ms = new MabStorage();
    }

    @Override
    public void execute(ArrayList<Task> list) throws MabException {
        list.addAll(ms.read());
    }
}
