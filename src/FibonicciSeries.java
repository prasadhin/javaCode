public class FibonicciSeries {

    private static long[] fibCache;

    public static void main(String[] args) {
        System.out.println("Hello World");
      /*  int input = 15;
        fibCache = new long[input + 1];
        Long[] result = new Long[input+1];
        System.out.println(fibonacci(input));
        result = Arrays.stream(fibCache).boxed().toArray(Long[] ::new);
        for (Long aLong : result) {
            System.out.print(aLong + " ");
        }*/

        getwhileFib();
    }

    private static long fibonacci(int n) {
        if (n <= 1) return n;
        if (fibCache[n] != 0) {
            return fibCache[n];
        }
        fibCache[n] = fibonacci(n - 2) + fibonacci(n - 1);
        return fibCache[n];
    }


    private static long getwhileFib(){
        long previousValue = 0;
        long prepreValue = 1;
        long currentValue = 1;
        for(int i=0;i<15;i++){
            System.out.println(previousValue);
            currentValue = previousValue + prepreValue;
            prepreValue = previousValue;
            previousValue = currentValue;


        }
        return previousValue;
    }
}
