package tn.lastdance.posts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.lastdance.posts.entity.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
