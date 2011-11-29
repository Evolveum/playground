package javaSource.errors;

public class Error {
    private String errorMessage = null;
    private String errorDetails = null;
    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public Error(String errorMessage, String errorDetails) {
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }
    public String getErrorDetails() {
        return errorDetails;
    }
    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
