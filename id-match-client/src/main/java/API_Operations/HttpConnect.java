package API_Operations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class HttpConnect {


    public HttpURLConnection connect(String URL_Prefix, String ADMIN_NAME, String ADMIN_PASSWORD, String suffix) {

        String Url = URL_Prefix + suffix;

        URL url = null;
        try {
            url = new URL(Url);
        } catch (MalformedURLException e) {
            System.out.println("URL creating failed.");
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) Objects.requireNonNull(url).openConnection();
        } catch (IOException e) {
            System.out.println("HttpURLConnection failed.");
        }


        if (connection != null) {
            String authString = ADMIN_NAME + ":" + ADMIN_PASSWORD;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(authString.getBytes(StandardCharsets.UTF_8));
            String authHeaderValue = "Basic " + new String(encodedAuth);


            connection.setRequestProperty("Authorization", authHeaderValue);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            try {
                connection.setRequestMethod("PUT");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            connection.setRequestProperty("Content-Type", "application/json");

        }

        return connection;
    }

}
