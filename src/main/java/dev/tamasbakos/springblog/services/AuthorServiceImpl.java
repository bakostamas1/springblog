package dev.tamasbakos.springblog.services;

import dev.tamasbakos.springblog.models.Author;
import dev.tamasbakos.springblog.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public Author findAuthorByUsername(String username) {
    return authorRepository.findByUsername(username);
  }
}
