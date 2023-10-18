package tn.lastdance.posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.lastdance.posts.entity.Post;
import tn.lastdance.posts.repository.PostRepository;

import java.util.List;

@Service
public class PostService  {
    @Autowired
    private PostRepository postRepository;
    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
