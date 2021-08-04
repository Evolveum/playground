package ApacheHttpComponents.auth;


import org.apache.http.client.CredentialsProvider;

public interface Authentication {
   CredentialsProvider provider();
}
