import java.util.Arrays;

public class Anagram1 {
    public Anagram1() {
    }

    public String checkifAnagram(String firstString, String secondString){
        firstString = firstString.toLowerCase().replace(" ","");
        secondString = secondString.toLowerCase().replace(" ","");
        char[] firstchars = firstString.toCharArray();
        char[] secondchars = secondString.toCharArray();
        Arrays.sort(firstchars);
        Arrays.sort(secondchars);
        if(Arrays.equals(firstchars,secondchars)) return "Anagram";
        else return "Not a Anagram";
    }
    public static void main(String[] args) {
        String firstString = "Hitlers is good";
        String secondString = "good is Hirelt";
        Anagram1 anagram = new Anagram1();
        String result = anagram.checkifAnagram(firstString, secondString);
        System.out.println(result);
    }
}
