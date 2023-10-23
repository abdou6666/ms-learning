package tn.lastdance.cours.Response;

import javax.persistence.Column;

public class CourResponse {
    private long id;



    private String title;


    private String description;



    private String image;

    private int rating;

    public CommentResponse getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(CommentResponse commentResponse) {
        this.commentResponse = commentResponse;
    }

    private CommentResponse commentResponse;

    public long getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
