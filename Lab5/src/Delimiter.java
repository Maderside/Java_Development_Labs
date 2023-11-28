/**
 * Used to define a delimiter as a single token of sentence.
 */
public class Delimiter extends SingleToken{
    /**
     * Creates a delimiter instance
     * @param c Char, that is a delimiter
     */
    public Delimiter(char c){
        if(isDelimiter(c)){
            this.l = c;
        }
        else {
            throw new IllegalArgumentException("Char must be a delimiter");
        }
    }

    private static boolean isDelimiter(char c) {
        return c == ' ' || c == '!' || c == '?' || c == '.' || c == ',';
    }

}
