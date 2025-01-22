
public class ToDos extends Task{

    public ToDos(String t, boolean d){
        super(t,d);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", "T", super.toString());
    }
}
