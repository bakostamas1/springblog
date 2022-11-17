package dev.tamasbakos.springblog.repositories;

import dev.tamasbakos.springblog.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

  Author findByUsername(String username);
}
