/**
 * Used to define a letter as a single token of word.
 */
public class Letter extends SingleToken{

    /**
     * Creates a letter instance
     * @param c Char, that is a letter
     */
    public Letter(char c){
        if (Character.isLetter(c)){
            this.l = c;
        }

        else throw new IllegalArgumentException("Char must be a letter");
    }


}
