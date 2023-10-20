package tn.lastdance.posts.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
//@Builder
//@Document(collation = "posts")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "posts")
@Builder
public class Post {
    @Id
    private String postId;
    private String username;
    private String title;
    private String content;

}
