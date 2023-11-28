/**
 * Static utility class that is used to swap the words in each sentence of the text
 */
public class WordSwapper {
    public static Text swap(Text text)  {
        Sentence[] sentences = text.getSentences();
        for (Sentence snt : sentences) {
            snt.swapWords();
        }
        return new Text(sentences);
    }
}
