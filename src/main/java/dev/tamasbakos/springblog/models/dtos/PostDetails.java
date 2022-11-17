package dev.tamasbakos.springblog.models.dtos;

import dev.tamasbakos.springblog.models.Author;
import dev.tamasbakos.springblog.models.Post;

public record PostDetails(Post post, Author author) { }
