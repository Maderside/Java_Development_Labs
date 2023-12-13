/**
 * Describes a song type of composition, has a singer
 */
public class Song extends Composition{
    private final String singer;
    public Song(String name, String genre, float duration, String singer) {
        super(name, genre, duration);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public String toString() {
        return super.toString()+", "+singer;
    }
}
