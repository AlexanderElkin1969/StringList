package pro.sky.java.course2.stringlist;

public class InvalidIndexException extends RuntimeException {

    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }

}
