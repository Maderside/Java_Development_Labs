import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Used to define a sentence as a text token. Consist of words.
 */
public class Sentence extends CompositeToken {
    private Token[] tokens;     //Stores sentence structure tokens(words, delimiters)

    /**
     * Creates a sentence instance
     *
     * @param tkns Words, delimiters or letters
     */
    public Sentence(Token... tkns) {
        this.tokens = tkns;
    }

    public Token[] getTokens() {
        return Arrays.copyOf(tokens, tokens.length);
    }

    /**
     * Removes sequences of duplicated delimiters
     */
    public void removeDelimDuplicates() {
        List<Token> result = new ArrayList<Token>();

        for (Token current : tokens) {
            if (!(current instanceof Delimiter) || result.isEmpty() || !result.get(result.size() - 1).equals(current)) {
                result.add(current);
            }
        }
        this.tokens = result.toArray(new Token[0]);
    }

    /**
     * Swaps the first and the last word in the sentence
     */
    public void swapWords() {
        int indLast = tokens.length - 1;
        int indFirst = 0;
        Word first;
        Word last;
        //Finding the index and value of last word in the array
        while (!(tokens[indLast] instanceof Word)) {
            indLast--;
        }
        last = (Word) tokens[indLast];

        //Finding the index of first word in the array
        while (!(tokens[indFirst] instanceof Word)) {
            indFirst++;
        }
        first = (Word) tokens[indFirst];

        //Swapping words in the sentence
        tokens[indFirst] = last;
        tokens[indLast] = first;
    }

    @Override
    public int length() {
        return tokens.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Token tkn : tokens) {
            str.append(tkn.toString());
        }
        return str.toString();
    }

    protected Sentence copy()  {
        Sentence copy = new Sentence();

        copy.tokens = this.getTokens();
        return copy;
    }
}

