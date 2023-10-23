package tn.esprit.ms.Service;

import tn.esprit.ms.Entities.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getPosts();
    public Post getPostById(long id);



    public Post savePost(Post post);
    public List<Post> savePosts(List<Post> posts);

    public String deletePost(Long idPost);
    public Post upadatePost(Post post);

    public void assignPostToForum (Long idPost, Long idForum);










}
