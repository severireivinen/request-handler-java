package actions;

public class Confirm implements IAction {
    private String source;
    private String paymentNumber;

    public Confirm(String source, String paymentNumber) {
        this.source = source;
        this.paymentNumber = paymentNumber;
    }

    public String toString() {
        return "Action type: " + this.getClass().getSimpleName() + "\nSource: " + source + "\nPayment number: " + paymentNumber;
    }
}
