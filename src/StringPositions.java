import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringPositions {

    public static void main(String[] args) {
        String inputString = "Marry had a little lamb, Marry dorsetplamk had a little lamb";
        //getPosition(inputString);
        //getChars(inputString);
        //getWords(inputString);
        //getLargestString(inputString);
        //getMaxWord();
        checkIfAlphabetInWord();
    }

    private static void getPosition(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            System.out.print(inputString.indexOf(inputString.charAt(i)) + "-" + inputString.charAt(i) + ", ");
        }
    }

    //java 8 method of collecting string to chars
    private static void getChars(String inputString) {
        System.out.println("\ngetChars");
        char[] inputstringChars = inputString.toCharArray();
        for (char c : inputstringChars) {
            System.out.print(c + "");
        }
    }

    //String to words list
    private static void getWords(String inputString) {
        System.out.println("\nget Words");
        String[] words = inputString.split(" ");
        for (String word : words) {
            System.out.print(word + " ");
        }

        // covert to List
        System.out.println("\narray to list");
        List<String> wordsAL = Arrays.asList(words);
        wordsAL.forEach((i) -> System.out.print(i + " "));
    }

    private static void getLargestString(String inputString) {
        char[] inputstringChars = inputString.toCharArray();
        int maxLength = 0;
        String maxString = "";


        for (int i = 0; i < inputString.length(); i++) {
            System.out.println("--");
            System.out.print(inputstringChars[i]);
            int tempLength = 0;
            StringBuilder largerString = new StringBuilder();
            String tempString = largerString.append(inputstringChars[i]).toString();

            for (int j = i + 1; j < inputString.length(); j++) {
                //System.out.print(inputstringChars[j]);

                if (largerString.indexOf(String.valueOf(inputstringChars[j])) == -1) {
                    largerString.append(inputstringChars[j]);
                    //System.out.print("formed-"+largerString.append(inputstringChars[j]).toString()+"-");
                } else break;
            }
            tempString = largerString.toString();
            tempLength = tempString.length();
            if (tempLength > maxLength) {
                maxString = tempString;
                maxLength = tempLength;
            }
            System.out.print("-First identified MaxString " + tempString + " is of length " + tempLength);
        }
        System.out.println(".");
        System.out.println("MaxString " + maxString + " is of length " + maxLength);
    }


    private static void getMaxWord() {
        String s = "hello dasdasdasd i am in fsad";

        String longest = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null).toString();

        System.out.println(longest + " and the length- " + longest.length());
    }

    private static void checkIfAlphabetInWord() {
        StringBuilder input = new StringBuilder("Marry hhad a alittle lammb");
        String maxString = "";
        String tempString = "" + input.charAt(0);
        Character charUnderCheck;
        String strUnderCheck ="";
        for (int i = 0, j = 1; j < input.length(); j++) {
            charUnderCheck = input.charAt(j);
            strUnderCheck = String.valueOf(charUnderCheck);
            if (tempString.indexOf(strUnderCheck) == -1) {
                tempString = tempString + charUnderCheck;
                if (tempString.length() > maxString.length()) maxString = tempString;
            } else {
                i = input.indexOf(strUnderCheck, i);
                i++;
                tempString = input.substring(i,j+1);
            }
        }
        System.out.println("Maximum String -" + maxString);
    }

   /*     StringBuilder input =  new StringBuilder("Marry had a lit");
        char charUnderCheck = input.charAt(14);
       String strUnderCheck = String.valueOf(charUnderCheck);
        int index= input.indexOf(strUnderCheck,5);
        System.out.println(index);
}*/
}