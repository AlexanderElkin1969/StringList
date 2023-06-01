package pro.sky.java.course2.myList.exception;

public class InvalidIndexException extends RuntimeException {

    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }

}
