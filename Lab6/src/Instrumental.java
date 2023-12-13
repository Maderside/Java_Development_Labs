/**
 * Describes an instrumental type of composition, has a number of instruments
 */
public class Instrumental extends Composition{
    private final int numOfInst;
    public Instrumental(String name, String genre, float duration, int n) {
        super(name, genre, duration);
        this.numOfInst = n;
    }

    public int getNumOfInst() {
        return numOfInst;
    }

    @Override
    public String toString() {
        return super.toString()+", number of instruments: "+numOfInst;
    }
}

