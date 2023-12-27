import java.io.Console;

public class ExceptionHandler {

    public static void handle(IndexOutOfBoundsException ex){
        System.out.println("Index is out of bounds, try another index | "+ex.getMessage());
    }
}
