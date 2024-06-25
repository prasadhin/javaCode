import java.util.HashMap;
import java.util.Map;

public class LargestString {

    public static String getLongestString(String sentence){
        String word = sentence.replace(" ","");
        StringBuilder result = new StringBuilder();
        String maxString = "";
        char[] sentenceCharacters = word.toCharArray();
        Map<Character, Integer> characterPosition = new HashMap<>();
        if(sentenceCharacters!=null) {
            characterPosition.put(sentenceCharacters[0], 0);
            result.append(sentenceCharacters[0]);
        }
        for(int i=0,j=1;j<sentenceCharacters.length;j++){
            result = new StringBuilder(word.substring(i,j));
            if(characterPosition.containsKey(sentenceCharacters[j]) && characterPosition.get(sentenceCharacters[j])>=i && characterPosition.get(sentenceCharacters[j])<=j) {
                i= characterPosition.get(sentenceCharacters[j]) + 1;
            }
            else{
                result.append(sentenceCharacters[j]);
                characterPosition.put(sentenceCharacters[j],j);
            }
            if(result.length()>maxString.length()) maxString = result.toString();
        }
        return maxString;
    }

    public static void main(String[] args) {
        String sentence = "The Lord is good, his mercy endures for ever";
        String result = getLongestString(sentence);
        System.out.println(result);
    }
}
