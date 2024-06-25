public class PrintPatterns {
    public static void main(String[] args) {
        printPattern3(4,4);
    }
    static void printPattern1(Integer rows, Integer columns){
        for(int row=1;row<=rows;row++){
            for(int column=1;column<=columns;column++) {
                System.out.print(column+" ");
            }
            System.out.println("");
        }
    }

    static void printPattern2(Integer rows, Integer columns){
        for(int row=1;row<=rows;row++){
            for(int column=1;column<=row;column++) {
                System.out.print(column+" ");
            }
            System.out.println("");
        }
    }

    static void printPattern3(Integer rows, Integer columns){
        for(int row=1;row<=rows;row++){
            int pausePrinting = (columns - row);
            for(int column=1;column<=columns;column++) {
                if (column<=pausePrinting) System.out.print(" ");
                else System.out.print(column);
            }
            System.out.println("");
        }
    }
}
