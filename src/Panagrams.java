import java.util.*;

public class Panagrams {

    public static void main(String[] args) {
//Check if panagram
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String input = "The quick brown fox jumps over the lazy doG";

        char[] charaters = alphabets.toCharArray();
        Map<Character, Integer> charStore = new HashMap();
/*        for (char c : charaters) {
            charStore.put(c,0);
        }*/

        char[] inputChars = input.replace(" ","").toUpperCase().toCharArray();
        for (char c : inputChars) {
            charStore.put(c,1);
        }

/*        //method 1
        if(charStore.containsValue(0)) System.out.println("M1 Not a Panagram");
        else System.out.println("M1 Is a panagram");*/

        //method 2
        //only load inputs in hashmap and then check if any of the alphabets not in
        boolean anagram = true;
        for (char c : charaters) {
            if(charStore.get(c)==null) {
                anagram=false;
                break;
            }
        }
        if(anagram) System.out.println("M2 Is a panagram");
        else System.out.println("M2 Not a Panagram");

        System.out.println(charStore);
    }

/*    int num = charaters[0];
        System.out.println(num);*/
}
