import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Word");
        System.out.println("Original string: " + str);
        System.out.println("Original length: " + str.length());

        str = WordSwitcher.switchWordsInText(str);

        System.out.println("Modified string: " + str);
        System.out.println("Modified string length: " + str.length());
        

    }
}