package dev.tamasbakos.springblog.repositories;

import dev.tamasbakos.springblog.models.Post;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

  @Query("SELECT * FROM POST WHERE author = :id")
  List<Post> findByAuthor(Integer id);

}
