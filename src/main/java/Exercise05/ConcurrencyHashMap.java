package Exercise05;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyHashMap {
    public static void main(String[] args) {
        var status = new MapStatus();

        List<Thread> threads = new ArrayList<>();
        for(var i=0; i<10; i++) {
            Thread thread = new Thread(new CustomHashMap(status));
            thread.start();
            threads.add(thread);
        }

        for(var thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(status.getTotal());
    }
}
