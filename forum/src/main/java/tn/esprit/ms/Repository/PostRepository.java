package tn.esprit.ms.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ms.Entities.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,Long>
{

}
