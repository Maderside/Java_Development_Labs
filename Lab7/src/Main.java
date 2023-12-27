import Music.Composition;
import Music.Ringtone;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Composition> list = new MyList<>();
        list.add(new Ringtone("Ringtone 1", "calm", 2.4F));
        list.add(new Ringtone("Ringtone 2", "calm", 2.4F));

        System.out.println(list);
        try{
            list.add(4, new Ringtone("Middle", "calm", 2.4F));
            System.out.println(list);
        }
        catch (IndexOutOfBoundsException ex){
            ExceptionHandler.handle(ex);
        }

    }
}