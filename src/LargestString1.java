import java.util.HashMap;
import java.util.Map;

public class LargestString1 {


    static String input = "Marry had a little lamb, little lamb";
    //static String input1 = "Marryhadalittlelamb,littlelamb";

    public static void main(String[] args) {
        Map<Character,Integer> mapStore = new HashMap<>();
        String tempString = "";
        String largestString = "";
        //String input = input1.replace(" ","");
        char[] inputChars = input.toCharArray();
        largestString = ""+inputChars[0];;
        tempString = ""+inputChars[0];
        mapStore.put(inputChars[0],0);
        for(int i=0,j=1;j<input.length();j++){
            if(mapStore.containsKey(inputChars[j]) && mapStore.get(inputChars[j])>=i){
                System.out.println("sliding at=>"+i+","+j+inputChars[j]);
                //slide the window
                //find previous poistion of character and increment by one
                i=mapStore.get(inputChars[j])+1;
                //update the position in hashmap with latest occurence of character
                mapStore.put(inputChars[j],j);
                tempString = input.substring(i,j)+inputChars[j];

                //System.out.println(tempString);
                //System.out.println(largestString);
            }
            else{
                //insert/update to map the latest character
                mapStore.put(inputChars[j],j);
                tempString = tempString + inputChars[j];

            }
            //compare temp and max string and update it
            if(tempString.length()>largestString.length()) largestString = tempString;
            System.out.println(tempString);
        }
        System.out.println(tempString);
        System.out.println(largestString);
    }
}
