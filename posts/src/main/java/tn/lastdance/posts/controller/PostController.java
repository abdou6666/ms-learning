package tn.lastdance.posts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.lastdance.posts.entity.Post;
import tn.lastdance.posts.service.PostService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/posts",consumes = "application/json",produces = "application/json")
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

    @PutMapping("{id}")
    public Post updatePost(@RequestBody Post post,@PathVariable("id") String id){
        return postService.updatePost(post);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<Post>> deletePost(@PathVariable("id") String id){
        Optional<Post> deletedPost = postService.deletePost(id);
        if(deletedPost.isPresent()){
            return ResponseEntity.ok(deletedPost);
        }
        return ResponseEntity.notFound().build();
    }
}
