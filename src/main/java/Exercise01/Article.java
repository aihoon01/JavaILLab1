package Exercise01;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class Article {
    private final Date date;
    private Post postCategory;

    Article() {
        this.date = new Date();
    }

    public void setPostCategory(Post post) {
        this.postCategory = post;
    }

    public Collection<String> publishPost(String content) {
        return this.postCategory.post(content);
    }

}
