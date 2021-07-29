
package auth;


import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class HttpBasicAuth implements Authentication {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void applyToParams(List<String> queryParams, Map<String, String> headerParams) {
        if (username == null && password == null) {
            return;
        }
        String auth = username + ":" + password;

        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);
        headerParams.put("Authorization",authHeaderValue);
    }
}

