package ApacheHttpComponents;

import ApacheHttpComponents.auth.AuthenticationProvider;

import java.io.IOException;

public interface ApacheApiRequest {
     void doRequest(AuthenticationProvider authenticationProvider, String urlPrefix, String jsonString, String urlSuffix) throws IOException;

}
