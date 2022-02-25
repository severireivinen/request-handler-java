package actions;

public class Login implements IAction {
    private String source;

    public Login(String source) {
        this.source = source;
    }

    public String toString() {
        return "Action type: " + this.getClass().getSimpleName() + "\nSource: " + source;
    }
}
