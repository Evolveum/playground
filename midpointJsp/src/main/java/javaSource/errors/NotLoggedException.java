package javaSource.errors;

public class NotLoggedException extends Exception {
	private static final long serialVersionUID = 1L;
	public NotLoggedException(Throwable cause) {
        super(cause);
    }
    public NotLoggedException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotLoggedException(String message) {
        super(message);
    }
    public NotLoggedException() {
    }
}
