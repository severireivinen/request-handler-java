import actions.IAction;

public class Main {
    public static void main(String[] args) throws Exception {
        String login = "visma-identity://login?source=severa";
        String confirm = "visma-identity://confirm?source=netvisor&paymentnumber=102226";
        String sign = "visma-identity://sign?source=vismasign&documentid=47ed9186-2ba0-4e8b-b9e2-7123575fdd5b";
        RequestHandler handler = new RequestHandler(confirm);

        IAction action = handler.handleUri();

        System.out.println(action);
    }
}
