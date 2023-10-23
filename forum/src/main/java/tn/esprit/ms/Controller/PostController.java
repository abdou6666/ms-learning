package tn.esprit.ms.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ms.Entities.Post;
import tn.esprit.ms.Service.IPostService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
public class PostController {

    IPostService postService;

    @GetMapping("/posts")
    private List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/post/{idPost}")
    private Post getPost(@PathVariable("idPost") long idPost) {
        return postService.getPostById(idPost);
    }


    @PostMapping("/addPost")
    public Post savePost (@RequestBody Post post){
        return postService.savePost(post);
    }

    @PostMapping("/addPosts")
    public List<Post> savePosts(@RequestBody List<Post> posts){
        return postService.savePosts(posts);
    }


    @PutMapping("/updatePost")
    public Post updatePost (@RequestBody Post post){
        return postService.upadatePost(post);
    }

    @DeleteMapping("/deletePost/{idPost}")
    public String deletePost (@PathVariable("idPost") Long idPost){
        return postService.deletePost(idPost);
    }


    @PutMapping("/assignPostToForum/{idPost}/{idForum}")
    public void assignPostToForum(@PathVariable("idPost") Long idPost,
                                            @PathVariable("idForum") Long idForum){

        postService.assignPostToForum(idPost, idForum);
    }


}
