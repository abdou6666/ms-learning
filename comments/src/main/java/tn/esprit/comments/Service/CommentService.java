package tn.esprit.comments.Service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.comments.Entity.Comment;
import tn.esprit.comments.Repository.CommentRepository;
import tn.esprit.comments.Response.CommentReponse;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper mapper;
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }




    public CommentReponse findAddressByEmployeeId(Long courId) {
        Optional<Comment> addressByEmployeeId = commentRepository.findAddressByEmployeeId(courId);
        CommentReponse addressResponse = mapper.map(addressByEmployeeId, CommentReponse.class);
        return addressResponse;
    }

}
