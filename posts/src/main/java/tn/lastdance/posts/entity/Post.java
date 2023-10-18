package tn.lastdance.posts.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
@Builder
@Document(collation = "posts")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    @Id
    private String postId;
    private String username;
    private String title;
    private String content;
    public Post(){
        super();
    }

    public Post(String postId, String username, String title, String content) {
        this.postId = postId;
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
