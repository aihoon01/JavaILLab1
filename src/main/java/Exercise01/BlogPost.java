package Exercise01;

import java.util.*;
import java.util.stream.Stream;

public class BlogPost implements Post{
    @Override
    public Collection<String> post(String content) {
        List<String> details = new ArrayList<>();
        details.add(content);
        return Arrays.asList(String.valueOf(details.stream()));
    }
}
