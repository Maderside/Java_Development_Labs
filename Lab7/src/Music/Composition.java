package Music;

/**
 * Superclass, describe basic interface and functionality for composition subclasses
 */
public abstract class Composition {
    private final String name;
    private final String genre;
    private final float duration;


    public Composition(String name, String genre, float duration){
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public float getDuration(){
        return duration;
    };

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString(){
        return "'"+name+"'"+ ", " + genre +", "+ duration+"m";
    };
}
