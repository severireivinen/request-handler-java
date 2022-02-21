package actions;

import java.util.UUID;

public class Sign {
    private String source;
    private UUID documentId;

    public Sign(String source, UUID documentId) {
        this.source = source;
        this.documentId = documentId;
    }

    public String toString() {
        return "Action type: " + this.getClass().getSimpleName() + "\nSource: " + source + "\nDocument id: " + documentId;
    }
}
