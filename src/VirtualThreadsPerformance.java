import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadsPerformance{

    static void createThread(){
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(() ->{
            System.out.println("Thread name"+Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread after name"+Thread.currentThread().getName());
        });
    }

    static void createStreamOfThreads(){
        var start = System.currentTimeMillis();
        var totalThread = 500000;
        IntStream.range(0, totalThread)
            .mapToObj(
                thCount -> Thread.ofVirtual().unstarted(() -> {
                })).toList();

        var threads = IntStream.range(1,totalThread)
            .mapToObj(
                (i) -> Thread.ofVirtual().unstarted(() -> {
                        System.out.println("-"+i+"- "+Thread.currentThread().getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    System.out.println("!"+i+"! "+Thread.currentThread().getName());
                    }
                )
        ).toList();
        threads.forEach(Thread::start);
        for(Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        var end = System.currentTimeMillis();
        System.out.println("millis used to launch " + totalThread + "vthreads:" + (end - start) + "ms");
    }

    public static void main(String[] args) {
        createStreamOfThreads();

    }

}