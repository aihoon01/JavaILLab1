package ThreadPool.SynchronizedBlock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedBlock {

    public static void main(String[] args) {
        var counter = new Counter();
        var executor = Executors.newFixedThreadPool(2);
        for(int i=1; i<=2; i++) {
            executor.submit(counter::incrementCounter);
        }
        executor.shutdown();

        try {
            if(!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("All tasks completed!, Counter should be 20");
        System.out.println("Output: " + counter.getCounter());
    }
}
