package tn.esprit.ms.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ms.Entities.Forum;
import tn.esprit.ms.Entities.Post;
import tn.esprit.ms.Repository.ForumRepository;
import tn.esprit.ms.Repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;


@AllArgsConstructor
@Service
public class PostService implements IPostService {


    PostRepository postRepository;

    ForumRepository forumRepository;

    @Override
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> savePosts(List<Post> posts) {
        return postRepository.saveAll(posts);
    }

    @Override
    public String deletePost(Long idPost) {
        postRepository.deleteById(idPost);
        return "Post supprimé !" + idPost;
    }

    @Override
    public Post upadatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void assignPostToForum(Long idPost, Long idForum) {

        Post post = this.postRepository.findById(idPost).orElse(null);
        Forum forum = this.forumRepository.findById(idForum).orElse(null);

        post.setForum(forum);
        postRepository.save(post);

    }

}




