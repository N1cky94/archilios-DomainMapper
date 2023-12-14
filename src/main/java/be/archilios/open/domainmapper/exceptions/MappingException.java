package be.archilios.open.domainmapper.exceptions;

public class MappingException extends RuntimeException {
    public MappingException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public MappingException(Throwable cause) {
        super(cause);
    }
    
    public MappingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    public MappingException() {
    }
    
    public MappingException(String message) {
        super(message);
    }
}
