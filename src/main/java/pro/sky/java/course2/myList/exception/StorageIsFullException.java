package pro.sky.java.course2.myList.exception;

public class StorageIsFullException extends RuntimeException {

    public StorageIsFullException() {
    }

    public StorageIsFullException(String message) {
        super(message);
    }

}
