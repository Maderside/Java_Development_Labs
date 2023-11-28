import java.util.ArrayList;

/**
 * Used to define a word as a sentence token, consists of letters
 */
public class Word extends CompositeToken{
    private final Letter[] letters;

    public Word(Letter... ltrs){
        this.letters = ltrs;
    }

    public Word(Letter ltr){
        this.letters = new Letter[]{ltr};
    }

    public Word(char... ltrs){
        ArrayList<Letter> listTmp = new ArrayList<Letter>();
        for (char c : ltrs){
            Letter l = new Letter(c);
            listTmp.add(l);
        }
        Letter[] lettersArr = new Letter[listTmp.size()];
        this.letters = listTmp.toArray(lettersArr);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Letter ltr : letters){
            str.append(ltr.l);
        }
        return str.toString();
    }

    @Override
    public int length() {
        return this.letters.length;
    }
}
