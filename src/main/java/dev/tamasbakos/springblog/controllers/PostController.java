package dev.tamasbakos.springblog.controllers;

import dev.tamasbakos.springblog.models.Post;
import dev.tamasbakos.springblog.models.dtos.PostDetails;
import dev.tamasbakos.springblog.repositories.AuthorRepository;
import dev.tamasbakos.springblog.repositories.PostRepository;
import dev.tamasbakos.springblog.services.AuthorService;
import dev.tamasbakos.springblog.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

  private static final Logger LOG = LoggerFactory.getLogger(PostController.class);

  private final PostRepository posts;
  private final AuthorRepository authors;
  private final PostService postService;
  private final AuthorService authorService;


  public PostController(PostRepository postRepository, AuthorRepository authorRepository,
      PostService postService, AuthorService authorService) {
    this.posts = postRepository;
    this.authors = authorRepository;
    this.postService = postService;
    this.authorService = authorService;
  }

  @GetMapping
  public Iterable<Post> findAll() {
    return postService.findAllPosts();
  }

  @GetMapping("/{id}")
  public Post findById(@PathVariable("id") Post post) {
    return post;
  }

  @GetMapping("/{id}/details")
  public PostDetails getPostDetails(@PathVariable("id") Post post) {
    LOG.info("Post Details called for: " + post.getId());
    return new PostDetails(post,authors.findById(post.getAuthor().getId()).get());
  }


}
