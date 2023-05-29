package pro.sky.java.course2.stringlist;

public class NotFoundElementException extends RuntimeException{

    public NotFoundElementException() {
    }

    public NotFoundElementException(String message) {
        super(message);
    }

    public NotFoundElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundElementException(Throwable cause) {
        super(cause);
    }

    public NotFoundElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
