public class CharacterProcess {



// Split string to words
    static void getWords(String s){

        s+=" ";
        char[] chars = s.toCharArray();
        String word = "";
        String outputSentence = "";
        for(int i=0;i<chars.length;i++){
            if(Character.isWhitespace(chars[i])) {
                System.out.println(word);
                outputSentence += word;
                word = "";
            }
            else word = word+chars[i];
        }

    }

    static void convertToCapitalCase(String s){
        s+=" ";
        char[] chars = s.toCharArray();
        String word = "";
        String outputSentence = "";
        Integer count = 0;
        for(int i=0;i<chars.length;i++){
            if(Character.isWhitespace(chars[i])) {
                String startLetter = (word.charAt(0)+"").toUpperCase();
                word = startLetter + word.substring(1);
                System.out.println(word);
                outputSentence += word;
                word = "";
                count++;
            }
            else word = word+chars[i];
        }
    }
    static void convertToCamelCase(String s){
        s+=" ";
        char[] chars = s.toCharArray();
        String word = "";
        String outputSentence = "";
        Integer count = 0;
        for(int i=0;i<chars.length;i++){
            if(Character.isWhitespace(chars[i])) {
                String startLetter = "";
                if(count%2 == 0) startLetter = (word.charAt(0)+"").toUpperCase();
                else startLetter = (word.charAt(0)+"").toLowerCase();
                word = startLetter + word.substring(1);
                System.out.println(word);
                outputSentence += word;
                word = "";
                count++;
            }
            else word = word+chars[i];
        }
    }

    public static void main(String[] args) {
        String s = "like Marry had a little lamb";
        //getWords(s);
        convertToCapitalCase(s);
    }
    //alternate capital case in a String
    //like Marry had a little lamb
    //like Marry had A little Lamn
   /*static String convertToCapitalCase(String input){
       Function<String, String> toCamelCase = (a) -> {
           char[] inputChars = a.toCharArray();
           int length = inputChars.length;
           String word = "";
           for(int i=0;i<length;i++){
               if(Character.isWhitespace(a.charAt(i))) {
                   break;
               }
               else word =a.charAt(i)+word;
               a.charAt(i) = a.charAt(i)+"".toUpperCase();
           }
           return "b";
       };
   return "";
   }*/

//seperate number and String in a String amd concatenate
}
