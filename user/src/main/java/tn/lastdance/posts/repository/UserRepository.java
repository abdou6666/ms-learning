package tn.lastdance.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.lastdance.posts.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   // Optional<Post> findByPostId(String id);
}
