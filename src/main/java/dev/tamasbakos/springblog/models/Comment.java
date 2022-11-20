package dev.tamasbakos.springblog.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;

public final class Comment {

  @Id
  @JsonIgnore
  private Integer id;
  private String name;
  private String content;
  private LocalDateTime publishedOn;
  private LocalDateTime updatedOn;
  @Transient
  Post post;

  public Comment(String name, String content) {
    this.name = name;
    this.content = content;
    this.publishedOn = LocalDateTime.now();
  }

  @PersistenceCreator
  @JsonCreator
  public Comment(String name, String content, LocalDateTime publishedOn, LocalDateTime updatedOn) {
    this.name = name;
    this.content = content;
    this.publishedOn = publishedOn;
    this.updatedOn = updatedOn;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getPublishedOn() {
    return publishedOn;
  }

  public void setPublishedOn(LocalDateTime publishedOn) {
    this.publishedOn = publishedOn;
  }

  public LocalDateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(LocalDateTime updatedOn) {
    this.updatedOn = updatedOn;
  }

  @Override
  public String toString() {
    return "Comment{" +
        "name='" + name + '\'' +
        ", content='" + content + '\'' +
        ", publishedOn=" + publishedOn +
        ", updatedOn=" + updatedOn +
        '}';
  }
}
