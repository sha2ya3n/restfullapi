package sha2ya3n.the2gen3tel4man.restfullapi.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ResourceNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ResourceNotFoundException(String message, Throwable throwable, boolean enablesuppresion, boolean writableStackTrace) {
        super(message, throwable, enablesuppresion, writableStackTrace);
    }
}
