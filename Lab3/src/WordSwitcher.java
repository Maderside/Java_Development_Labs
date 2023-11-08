import java.util.*;

public class WordSwitcher {

    private static Set<Character> specialChars = new HashSet<>(Arrays.asList(' ', '.', '?', '!'));
    public static StringBuffer switchWordsInText(StringBuffer str){
        List<String> sntList = getSentences(str);
        StringBuffer txt = new StringBuffer();
        StringBuffer sntBf;

        for (String snt: sntList) {
            sntBf = switchWordsInSentence(snt);
            txt.append(sntBf);
        }
        return txt;

    }
    private static StringBuffer  switchWordsInSentence(String snt){
        StringBuffer str = new StringBuffer(snt);
        int firstWordStart = getFirstWordStart(str);
        int lastWordEnd = getLastWordEnd(str);

        //if there is no words or only one word in the string
        if (firstWordStart == -1 || lastWordEnd == -1){
            return str;
        }

        int firstWordEnd = str.indexOf(" ", firstWordStart)-1;
        int lastWordStart = str.lastIndexOf(" ", lastWordEnd)+1;

        //if there is no words or only one word in the string
        if (firstWordEnd < 0 || lastWordStart < 0){
            return str;
        }

        String firstWord = str.substring(firstWordStart, firstWordEnd+1);
        String lastWord = str.substring(lastWordStart,lastWordEnd+1);

        int origLength = str.length();
        str.replace(firstWordStart, firstWordEnd + 1, lastWord);

        int shift = str.length() - origLength;      //shift of the word start index when the length of the string is changed
        str.replace(lastWordStart + shift, lastWordEnd + 1 + shift, firstWord);

        return str;

    }



    private static List<String> getSentences(StringBuffer str) {

        // Use a regular expression pattern to split on '.', '!', or '?'
        String[] sentences = str.toString().split("(?<=[.!?])");

        return new ArrayList<String>(Arrays.asList(sentences));
    }
    private static int getLastWordEnd(StringBuffer str){
        if (str.isEmpty()){
            return -1;
        }
        int ind = str.length()-1;
        while (specialChars.contains(str.charAt(ind))){
            ind--;
            if (ind < 0){
                return -1;
            }
        }

        return ind;
    }
    private static int getFirstWordStart(StringBuffer str){
        if (str.isEmpty()){
            return -1;
        }
        int ind = 0;
        while (specialChars.contains(str.charAt(ind))){
            ind++;
            if (ind > str.length() - 1){
                return -1;
            }
        }

        return ind;
    }
}
