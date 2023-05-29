package pro.sky.java.course2.stringlist;

public class NotFoundElementException extends RuntimeException{

    public NotFoundElementException() {
    }

    public NotFoundElementException(String message) {
        super(message);
    }

}
