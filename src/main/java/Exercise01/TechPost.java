package Exercise01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TechPost implements Post{
    List<String> techUpdates = new ArrayList<>();

    @Override
    public Collection<String> post(String content) {
        techUpdates.add(content);
        return techUpdates;
    }
}
