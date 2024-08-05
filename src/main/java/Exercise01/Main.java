package Exercise01;

import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    var article = new Article();
    article.setPostCategory(new TechPost());

    Collection<String> posts = article.publishPost("Hi there welcome to SpringBoot 8");
    posts.stream().forEach(System.out::println);
    }
}
