package dev.tamasbakos.springblog;

import dev.tamasbakos.springblog.models.Author;
import dev.tamasbakos.springblog.models.Comment;
import dev.tamasbakos.springblog.models.Post;
import dev.tamasbakos.springblog.repositories.AuthorRepository;
import dev.tamasbakos.springblog.repositories.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class SpringBlogApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBlogApplication.class, args);
  }

  @Profile({"dev"/*, "prod"*/})
  @Bean
  CommandLineRunner run(PostRepository postRepository, AuthorRepository authorRepository) {
    return args -> {
      AggregateReference<Author, Integer> author = AggregateReference.to(
          authorRepository.save(new Author(null, "Tamas", "Bakos", "tamas@bakos.com", "tamasbakos"))
              .id());

      Post post = new Post("Tamas' First Post", "This is Tamas' First Post", author);
      post.addComment(new Comment("Tamas", "This is a comment"));
      post.addComment(new Comment("Tim", "This is another comment"));
      postRepository.save(post);
    };
  }

}
