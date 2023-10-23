package tn.esprit.comments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.comments.Entity.Comment;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {@Query(
        nativeQuery = true,
        value
                = "SELECT ea.commentId, ea.content, ea.created_at FROM microcomments.comments ea join h2test.db.Cours e on e.commentId = ea.cours_id where ea.cours_id=:courId")
Optional<Comment> findAddressByEmployeeId(@Param("courId") Long courId);
}
