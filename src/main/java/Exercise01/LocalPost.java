package Exercise01;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class LocalPost implements Post{
    @Override
    public Collection<String> post(String content) {
        Collection<String> localNews = new HashSet();
        Collections.addAll(localNews, content);
        return localNews;
    }
}
