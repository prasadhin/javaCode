import java.util.*;

public class AnagramList {

    public boolean checkifAnagram(String input1, String input2){
        char[] input1Chars = input1.toCharArray();
        char[] input2Chars = input2.toCharArray();
        Arrays.sort(input1Chars);
        Arrays.sort(input2Chars);
        return Arrays.equals(input1Chars,input2Chars);
    }

    public List<List<String>> getAnagrams(String[] input){
        AnagramList anagramList = new AnagramList();
        Map<String, String> anagramStore = new HashMap<>();
        List<List<String>> listofAnagrams = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            List<String> anagram = new ArrayList<>();
            if(!anagramStore.containsKey(input[i])) {
                anagramStore.put(input[i],input[i]);
                anagram.add(input[i]);
                for(int j=i+1;j<input.length;j++){
                    if(!anagramStore.containsKey(input[j]) && anagramList.checkifAnagram(input[i],input[j])){
                        anagram.add(input[j]);
                        anagramStore.put(input[j],input[j]);
                    }
                }
                if(anagram.size()!=1) listofAnagrams.add(anagram);
            }
        }
        return  listofAnagrams;
    }

    public static void main(String[] args) {
        AnagramList anagramList = new AnagramList();
        String[] inpput = {"tea","eat","dart","ate","trad","ray","ears","easr"};
        List<List<String>> listofAnagrams = anagramList.getAnagrams(inpput);
        for(List<String> anagrams: listofAnagrams){
            System.out.println(anagrams);
        }
    }
}
