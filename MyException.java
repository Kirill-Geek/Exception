package Excteption;

public class MyException extends Exception {
    public MyException(String message, Exception e){
        super(message, e);
    }
}
