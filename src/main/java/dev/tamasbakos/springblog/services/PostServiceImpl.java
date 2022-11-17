package dev.tamasbakos.springblog.services;

import dev.tamasbakos.springblog.models.Post;
import dev.tamasbakos.springblog.repositories.PostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public Iterable<Post> findAllPosts() {
    return postRepository.findAll();
  }

  @Override
  public List<Post> findPostsByAuthorId(Integer authorId) {
    return postRepository.findByAuthor(authorId);
  }
}
