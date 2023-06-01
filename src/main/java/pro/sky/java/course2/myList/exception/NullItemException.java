package pro.sky.java.course2.myList.exception;

public class NullItemException extends RuntimeException{

    public NullItemException() {
    }

    public NullItemException(String message) {
        super(message);
    }

}
