package auth;


import java.util.List;
import java.util.Map;

public interface Authentication {
    void applyToParams(List<String> queryParams, Map<String, String> headerParams);
}
