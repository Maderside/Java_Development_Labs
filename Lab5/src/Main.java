public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Letter a = new Letter('a');

        Word word1 = new Word('H', 'e', 'l', 'l', 'o');
        Word word2 = new Word('n', 'e', 'w');
        Word word3 = new Word('w', 'o', 'r', 'l', 'd');

        Word word4 = new Word('T','h','e');
        Word word5 = new Word('n','a','t','u','r','e');
        Word word6 = new Word('a','w','a','k','e','n','s');

        Delimiter space = new Delimiter(' ');
        Delimiter coma = new Delimiter(',');
        Delimiter period = new Delimiter('.');

        //Creating sentence
        Sentence sentence1 = new Sentence(space,word1, coma, coma, space, word2, space, space, word3, period);
        Sentence sentence2 = new Sentence(space,word4, space, word5, space, space, space, word6, period);

        //Creating text
        Text text = new Text(sentence1, sentence2);

        System.out.println("Original text:");
        System.out.println(text);

        //Performing operations
        System.out.println("Deleting duplicates:");
        text.removeDelimDuplicates();
        System.out.println(text);

        System.out.println("Swapping words:");
        text = WordSwapper.swap(text);

        System.out.println(text);

    }
}