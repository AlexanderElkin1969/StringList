package pro.sky.java.course2.myList.exception;

public class NotFoundElementException extends RuntimeException{

    public NotFoundElementException() {
    }

    public NotFoundElementException(String message) {
        super(message);
    }

}
