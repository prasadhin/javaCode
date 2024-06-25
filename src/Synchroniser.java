import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Synchroniser {

    static IntPredicate oddNumber = (n) -> n%2!=0;
    static IntPredicate evenNumber = (n) -> n%2==0;

    public static void printNumbers(IntPredicate p){
        IntStream.range(1,100).filter(p).forEach(i -> System.out.println(i+" "+ Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> printNumbers(oddNumber),"oddThread");
        Thread evenThread = new Thread(() -> printNumbers(evenNumber),"evenThread");
        oddThread.start();
        evenThread.start();
    }



}
