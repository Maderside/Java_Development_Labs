import java.util.Arrays;

/**
 * Represents a text that consist of sentences
 */
public class Text extends CompositeToken{
    private final Sentence[] sentences;


    public Text(Sentence... sentences) {
        this.sentences = sentences ;
    }

    /**
     * Return the array of sentences from the text
     * @return Deep copy of the Sentence[] array
     */
    public Sentence[] getSentences() {
        Sentence[] copy = new Sentence[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            copy[i] = sentences[i].copy();
        }
        return copy;
    }

    /**
     * Removes duplicated delimiters sequences from each sentence of the text
     */
    public void removeDelimDuplicates(){
        for (Sentence sentence : sentences) {
            sentence.removeDelimDuplicates();
        }
    }

    @Override
    public int length() {
        return sentences.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Sentence snt : sentences){
            str.append(snt.toString());
        }
        return str.toString();
    }
}
