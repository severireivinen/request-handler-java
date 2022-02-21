import actions.Confirm;
import actions.Login;
import actions.Sign;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.UUID;

public class RequestHandler {
    private URI uri;
    private static final String validScheme = "visma-identity";
    private static final String[] validActions = {"login", "confirm", "sign"};
    private static final String[] loginParameters = {"source"};
    private static final String[] confirmParameters = {"source", "paymentnumber"};
    private static final String[] signParameters = {"source", "documentid"};

    public RequestHandler(String uri) throws URISyntaxException {
        this.uri = new URI(uri);
    }

    public Object handleUri() throws Exception {
        String scheme = uri.getScheme();
        String action = uri.getAuthority();
        String[] parameters = uri.getQuery().split("&");
        String[] parsedParams = Arrays.stream(parameters).map(p -> p.split("=")[0]).toArray(String[]::new);
        String[] paramValues = Arrays.stream(parameters).map(p -> p.split("=")[1]).toArray(String[]::new);

        // Validate scheme
        if (!validScheme.equals(scheme)) {
            throw new Exception("Invalid scheme");
        }

        // Validate action
        if (!Arrays.asList(validActions).contains(action)) {
            throw new Exception("Invalid action");
        }

        // Handle action and validate parameters
        switch (action) {
            case "login":
                if (Arrays.asList(loginParameters).equals(Arrays.asList(parsedParams))) {
                    return new Login(paramValues[0]);
                } else {
                    throw new Exception("Invalid parameters");
                }
            case "confirm":
                if (Arrays.asList(confirmParameters).equals(Arrays.asList(parsedParams))) {
                    return new Confirm(paramValues[0], paramValues[1]);
                } else {
                    throw new Exception("Invalid parameters");
                }
            case "sign":
                if (Arrays.asList(signParameters).equals(Arrays.asList(parsedParams))) {
                    return new Sign(paramValues[0], UUID.fromString(paramValues[1]));
                } else {
                    throw new Exception("Invalid parameters");
                }
            default:
                return null;
        }
    }
}
