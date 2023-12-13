import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Album alb = new Album(
                new Ringtone("Ringtone 1", "energetic", 3.5F),
                new Song("Song 1", "calm", 5F, "John"),
                new Song("Song 2", "energetic", 7.3F, "David"),
                new Instrumental("Instr 1", "energetic", 4.2F, 3),
                new Instrumental("Instr 2", "calm", 2.1F, 4)
        );
        System.out.println("Initial album content:");
        System.out.print(alb);
        System.out.println();

        System.out.println("Composition with a duration in range between 4m and 6m");
        System.out.println(alb.findComposition(4f,6f));
        System.out.println();

        System.out.println("Album duration");
        System.out.println(alb.countDuration()+"m");
        System.out.println();

        System.out.println("Compositions sorted by genre");
        alb.sort(Comparator.comparing(Composition::getGenre));
        System.out.println(alb);
        System.out.println();
    }
}