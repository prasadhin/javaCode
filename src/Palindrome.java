public class Palindrome {

    public static void main(String[] args) {
        String input = "The Lord drol eht";
        //input=input.replace(" ","");
        System.out.println(input);
        boolean result = isThisPalindrome(input);
        System.out.println(result);
    }

    public static boolean isThisPalindrome(String input){
        String output = "";
        char[] inputCharacters = input.toCharArray();
        for(int i=0;i<inputCharacters.length;i++){
         output = inputCharacters[i]+output;
        }
        System.out.println(output);
        if(output.equalsIgnoreCase(input)) return  true;
        else return false;
    }
}
