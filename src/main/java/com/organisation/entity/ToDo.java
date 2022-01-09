package com.organisation.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class ToDo {
  @Id
  @SequenceGenerator(name = "todo_id_sequence", allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "todo_id_sequence")
  private int id;

  @Column private String description;
  @Column private LocalDateTime createdAt;
  @Column private LocalDate dueDate;

  public ToDo() {
    // for spring framework only
  }

  public ToDo(String description, LocalDateTime createdAt, LocalDate dueDate) {
    this.description = description;
    this.createdAt = createdAt;
    this.dueDate = dueDate;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public int getId() {
    return id;
  }
}
