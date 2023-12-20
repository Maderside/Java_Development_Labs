import java.util.Arrays;
import java.util.Comparator;
import Music.Composition;
/**
 * Contains an array of compositions
 */
public class Album{
    private Composition[] comps;
    public Album(Composition... comps){
        this.comps = comps;
    }

    public float countDuration(){
        float sum = 0;
        for (Composition comp : comps){
            sum+=comp.getDuration();
        }
        return sum;
    }

    public Composition findComposition(float lower, float upper){
        for (Composition comp : comps){
            if (comp.getDuration() <= upper && comp.getDuration() >= lower){
                return comp;
            }
        }
        return null;
    }
    public void sort(Comparator<Composition> cmpr){
        Arrays.sort(comps, cmpr);
    }

    @Override
    public String toString(){
        StringBuilder bd = new StringBuilder();
        for (Composition comp : comps){
            bd.append(comp).append(System.lineSeparator());
        }
        return bd.toString();
    }
}
