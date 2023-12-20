import Music.Composition;
import Music.Ringtone;

public class Main {
    public static void main(String[] args) {
        MyList<Composition> list = new MyList<>();
        list.add(new Ringtone("Ringtone 1", "calm", 2.4F));
        list.add(new Ringtone("Ringtone 2", "calm", 2.4F));

        System.out.println(list);
        list.add(1, new Ringtone("Middle", "calm", 2.4F));
        System.out.println(list);
    }
}