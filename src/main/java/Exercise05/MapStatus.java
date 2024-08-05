package Exercise05;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapStatus {
    private Map<String, Integer> map = new ConcurrentHashMap<>();


    public int getTotal() {
        return this.map.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void addToMap(int param) {
        String key = String.valueOf(Math.random());
        map.put(key, param);
    }
}
