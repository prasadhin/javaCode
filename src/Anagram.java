import java.util.*;

public class Anagram {
    public Anagram() {
    }

    public static void main(String[] args) {
        //check if two strings are anagrams
        String firstString = "Hitlers is good";
        String secondString = "good is Hirelt";
        firstString = firstString.toLowerCase().replace(" ","");
        secondString = secondString.toLowerCase().replace(" ","");
        char[] firstchars = firstString.toCharArray();
        char[] secondchars = secondString.toCharArray();
        Arrays.sort(firstchars);
        Arrays.sort(secondchars);
        if(Arrays.equals(firstchars,secondchars)) System.out.println("Anagram");
        else System.out.println("Not Anagram");
    }
}
