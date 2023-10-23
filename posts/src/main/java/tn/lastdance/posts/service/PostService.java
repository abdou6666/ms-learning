package tn.lastdance.posts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.lastdance.posts.entity.Post;
import tn.lastdance.posts.repository.PostRepository;

import java.util.List;
import java.util.Optional;

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

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> deletePost(String id) {
        Optional<Post> post = postRepository.findByPostId(id);
        if(post.isPresent()){
            postRepository.deleteById(id);
            return post;
        }
        return Optional.empty();
    }
}
