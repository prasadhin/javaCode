import java.util.concurrent.atomic.AtomicInteger;

public class SynchroniserProdConsumer {
    static AtomicInteger momos = new AtomicInteger(0);
    int capacity = 100;
    void produceMomos() {
        while (true) {
            synchronized (this) {
                try {

                if (momos.get() >= capacity) {
                    this.wait();
                }
                momos.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + " - Total momos available - " + momos);
                    Thread.sleep(1000);
                this.notify();
                }
                catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        void consumeMomos()  {
            while(true) {
                synchronized (this) {
                    try {
                        //Thread.sleep(1000);

                    if (momos.get() <= 0) {

                        this.wait();
                    }
                        momos.getAndDecrement();
                        System.out.println(Thread.currentThread().getName() + " - Total momos available - " + momos);
                        Thread.sleep(1000);
                        this.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }



    public static void main(String[] args) {
        SynchroniserProdConsumer s = new SynchroniserProdConsumer();
        Thread prod = new Thread(() -> s.produceMomos(),"prod");
        Thread cons = new Thread(() -> s.consumeMomos(),"cons");
        prod.start();
        cons.start();
    }
}
