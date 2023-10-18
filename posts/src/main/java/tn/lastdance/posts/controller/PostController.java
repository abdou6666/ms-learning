package tn.lastdance.posts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.posts.entity.Post;
import tn.lastdance.posts.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping
    public Post save(@RequestBody Post post){
        return  postService.save(post);
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }
}
