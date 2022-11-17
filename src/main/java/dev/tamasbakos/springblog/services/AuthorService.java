package dev.tamasbakos.springblog.services;

import dev.tamasbakos.springblog.models.Author;

public interface AuthorService {

  Author findAuthorByUsername(String username);
}
