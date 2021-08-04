package ApacheHttpComponents;

import ApacheHttpComponents.auth.AuthenticationProvider;

import java.io.IOException;


public class ApacheContext {

    public ApacheApiRequest apacheApiRequest;

    public ApacheContext(ApacheApiRequest apacheApiRequest) {
        this.apacheApiRequest = apacheApiRequest;
    }

    public void executeRequest(AuthenticationProvider authenticationProvider, String urlPrefix, String jsonString, String urlSuffix){
        try {
            apacheApiRequest.doRequest(authenticationProvider,urlPrefix,jsonString,urlSuffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
