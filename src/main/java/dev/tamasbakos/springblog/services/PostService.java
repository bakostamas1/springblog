package dev.tamasbakos.springblog.services;

import dev.tamasbakos.springblog.models.Post;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  Iterable<Post>findAllPosts();
  List<Post> findPostsByAuthorId(Integer authorId);

}
