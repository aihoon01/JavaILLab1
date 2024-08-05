package Exercise05;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMap implements Runnable {
    private final MapStatus status;


    CustomHashMap(MapStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            Map<String, Integer> map = new HashMap<>();
            if(Thread.currentThread().isInterrupted()) return;
            System.out.println("Adding to Map");
            status.addToMap(10);
        }
        System.out.println("Download Complete: " + Thread.currentThread().getName());
    }
}
