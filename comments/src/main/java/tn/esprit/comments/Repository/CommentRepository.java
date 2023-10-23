package tn.esprit.comments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.comments.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}